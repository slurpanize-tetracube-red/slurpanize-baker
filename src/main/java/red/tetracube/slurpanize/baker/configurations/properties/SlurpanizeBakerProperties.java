package red.tetracube.slurpanize.baker.configurations.properties;

import io.smallrye.config.ConfigMapping;

@ConfigMapping(prefix = "slurpanize-baker")
public interface SlurpanizeBakerProperties {

    SecurityProperties security();

}