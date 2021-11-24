package red.tetracube.slurpanize.baker.foodlab.payloads;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class FoodlabFoundryRequest {

    @NotNull
    @NotEmpty
    @JsonProperty("foodlabName")
    public String name;

    @NotNull
    @NotEmpty
    @JsonProperty("administratorUsername")
    public String username;

    @NotNull
    @NotEmpty
    @JsonProperty("administratorPassword")
    public String password;

}
