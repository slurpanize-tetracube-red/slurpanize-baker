package tetracubered.slurpanizeBaker.authentication

import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody
import tetracubered.slurpanizeBaker.authentication.payloads.AuthenticationRequest
import tetracubered.slurpanizeBaker.authentication.payloads.AuthenticationResponse
import javax.validation.Valid
import javax.ws.rs.POST
import javax.ws.rs.Path
import javax.ws.rs.core.Response

@Path("/authenticate")
class AuthenticationController(
    private val authenticationServices: AuthenticationServices
) {

    @POST
    @Path("/admin")
    fun authenticateAdmin(@Valid @RequestBody authenticationRequest: AuthenticationRequest): Response {
        val authenticationResult = this.authenticationServices.authenticateUser(
            authenticationRequest.username!!,
            authenticationRequest.password!!
        )
        if (authenticationResult.isFailure) {
            throw authenticationResult.exceptionOrNull()!!
        }

        return Response.ok(
            AuthenticationResponse(
                authenticationResult.getOrNull()!!
            )
        )
            .build()
    }

}