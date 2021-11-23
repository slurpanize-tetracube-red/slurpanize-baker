package tetracubered.slurpanizeBaker.foodlabFoundry.payloads

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull

data class FoodlabFoundryRequest @JsonCreator constructor(
    @field:NotNull
    @field:NotEmpty
    @JsonProperty("foodlabName")
    val name: String? = null,

    @field:NotNull
    @field:NotEmpty
    @JsonProperty("administratorUsername")
    val username: String? = null,

    @field:NotNull
    @field:NotEmpty
    @JsonProperty("administratorPassword")
    val password: String? = null
)