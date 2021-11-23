package tetracubered.slurpanizeBaker.foodlabFoundry

import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody
import tetracubered.slurpanizeBaker.foodlabFoundry.payloads.FoodlabFoundryRequest
import javax.annotation.security.RolesAllowed
import javax.validation.Valid
import javax.ws.rs.POST
import javax.ws.rs.Path
import javax.ws.rs.core.Response

@RolesAllowed(value = ["SUPER_ADMIN"])
@Path("/foodlab-foundry")
class FoodlabFoundryController {

    @POST
    @Path("")
    fun foodlabFoundry(@Valid @RequestBody foodlabFoundryRequest: FoodlabFoundryRequest): Response {
        return Response.ok().build()
    }
}