package red.tetracube.slurpanize.baker.foodlab;

import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import red.tetracube.slurpanize.baker.foodlab.payloads.FoodlabFoundryRequest;

import javax.annotation.security.RolesAllowed;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@RolesAllowed(value = {"SUPER_ADMIN"})
@Path(value = "/foodlab")
public class FoodlabController {

    @POST
    @Path(value = "/foundry")
    @Consumes(value = MediaType.APPLICATION_JSON)
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response foodlabFoundry(@Valid @RequestBody FoodlabFoundryRequest foodlabFoundryRequest) {
        return Response.ok().build();
    }
}
