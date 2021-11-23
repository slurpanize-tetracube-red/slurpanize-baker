package tetracubered.slurpanizeBaker.authentication

import io.quarkus.security.UnauthorizedException
import io.smallrye.jwt.build.Jwt
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import tetracubered.slurpanizeBaker.configurations.properties.SlurpanizeBakerProperties
import java.time.Duration
import java.time.Instant
import javax.enterprise.context.ApplicationScoped


@ApplicationScoped
class AuthenticationServices(
    private val slurpanizeBakerProperties: SlurpanizeBakerProperties
) {

    private val passwordEncoder = BCryptPasswordEncoder()

    fun authenticateUser(username: String, password: String): Result<String> {
        if (this.slurpanizeBakerProperties.security().adminUsername() != username ||
            !this.passwordEncoder.matches(password, this.slurpanizeBakerProperties.security().adminPassword())
        ) {
            return Result.failure(UnauthorizedException("Invalid administration credentials"))
        }
        val token: String = Jwt.issuer(this.slurpanizeBakerProperties.security().jwtIssuer())
            .groups(setOf("SUPER_ADMIN"))
            .issuedAt(Instant.now())
            .expiresIn(Duration.ofMinutes(20))
            .subject(username)
            .sign()
        return Result.success(token)
    }

}