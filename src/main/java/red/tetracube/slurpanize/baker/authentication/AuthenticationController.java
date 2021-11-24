package red.tetracube.slurpanize.baker.authentication;

import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import red.tetracube.slurpanize.baker.authentication.payloads.AuthenticationRequest;
import red.tetracube.slurpanize.baker.authentication.payloads.AuthenticationResponse;

import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/authenticate")
public class AuthenticationController {

    private final AuthenticationServices authenticationServices;

    public AuthenticationController(AuthenticationServices authenticationServices) {
        this.authenticationServices = authenticationServices;
    }

    @POST
    @Path("/admin")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response authenticateAdmin(@Valid @RequestBody AuthenticationRequest authenticationRequest) {
        var token = this.authenticationServices.authenticateUser(
                authenticationRequest.username,
                authenticationRequest.password
        );
        var response = new AuthenticationResponse();
        response.token = token;
        return Response.ok(response).build();
    }
}
