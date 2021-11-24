package red.tetracube.slurpanize.baker.authentication.payloads;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class AuthenticationRequest {

    @NotNull
    @NotEmpty
    @JsonProperty("username")
    public String username;

    @NotNull
    @NotEmpty
    @JsonProperty("password")
    public String password;

}
