package red.tetracube.slurpanize.baker.foodlab;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import io.quarkiverse.rabbitmqclient.RabbitMQClient;
import io.quarkus.runtime.StartupEvent;
import io.quarkus.vertx.ConsumeEvent;
import io.vertx.core.json.Json;
import red.tetracube.slurpanize.baker.configurations.properties.SlurpanizeBakerProperties;
import red.tetracube.slurpanize.baker.foodlab.messages.AdministratorCreationMessage;
import red.tetracube.slurpanize.baker.foodlab.payloads.FoodlabFoundryRequest;

import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.inject.Singleton;
import java.io.IOException;
import java.io.UncheckedIOException;

@Singleton
public class FoodlabServices {

    @Inject
    RabbitMQClient rabbitMQClient;

    @Inject
    SlurpanizeBakerProperties slurpanizeBaker;

    private Channel channel;

    public void onApplicationStart(@Observes StartupEvent event) {
        this.setupQueues();
    }

    private void setupQueues() {
        try {
            var connection = rabbitMQClient.connect();
            channel = connection.createChannel();
            channel.queueDeclare(slurpanizeBaker.broker().createPlatformAdmin(), true, false, false, null);
            channel.queueBind(slurpanizeBaker.broker().createPlatformAdmin(), slurpanizeBaker.broker().topic(), slurpanizeBaker.broker().createPlatformAdmin());
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    public void generateFoodlabCreationEvent(FoodlabFoundryRequest foodlabFoundryRequest) throws IOException {
        var administrationCreationMessage = new AdministratorCreationMessage();
        administrationCreationMessage.username = foodlabFoundryRequest.username;
        administrationCreationMessage.password = foodlabFoundryRequest.password;
        var administrationCreationMessageEncoded = Json.encodeToBuffer(administrationCreationMessage).getBytes();
        this.channel.basicPublish(
                slurpanizeBaker.broker().topic(),
                slurpanizeBaker.broker().createPlatformAdmin(),
                null,
                administrationCreationMessageEncoded
        );
    }
}
