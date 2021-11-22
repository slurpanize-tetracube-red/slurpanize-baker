package tetracubered.slurpanize.baker.foodlabFoundry

import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody
import tetracubered.slurpanize.baker.foodlabFoundry.payloads.FoodlabFoundryRequest
import javax.validation.Valid
import javax.ws.rs.POST
import javax.ws.rs.Path
import javax.ws.rs.core.Response

@Path("/foodlab-foundry")
class FoodlabFoundryController {

    @POST
    @Path("")
    fun foodlabFoundry(@Valid @RequestBody foodlabFoundryRequest: FoodlabFoundryRequest): Response {
        return Response.ok().build()
    }
}