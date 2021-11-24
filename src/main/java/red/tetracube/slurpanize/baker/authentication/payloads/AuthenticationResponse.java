package red.tetracube.slurpanize.baker.authentication.payloads;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AuthenticationResponse {

    @JsonProperty("token")
    public String token;

}
