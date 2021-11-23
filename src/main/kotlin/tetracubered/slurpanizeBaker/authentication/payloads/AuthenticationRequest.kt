package tetracubered.slurpanizeBaker.authentication.payloads

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull

data class AuthenticationRequest @JsonCreator constructor(
    @field:NotNull
    @field:NotEmpty
    @JsonProperty("username")
    val username: String? = null,

    @field:NotNull
    @field:NotEmpty
    @JsonProperty("password")
    val password: String? = null
)