package tetracubered.slurpanizeBaker.authentication.payloads

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty

class AuthenticationResponse @JsonCreator constructor(
    @JsonProperty("token")
    val token: String
)