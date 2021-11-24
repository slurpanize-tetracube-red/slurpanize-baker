package red.tetracube.slurpanize.baker.authentication;

import io.quarkus.security.UnauthorizedException;
import io.smallrye.jwt.build.Jwt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import red.tetracube.slurpanize.baker.configurations.properties.SlurpanizeBakerProperties;

import javax.enterprise.context.ApplicationScoped;
import java.time.Duration;
import java.time.Instant;
import java.util.Collections;
import java.util.Objects;

@ApplicationScoped
public class AuthenticationServices {

    private final PasswordEncoder passwordEncoder;
    private final SlurpanizeBakerProperties slurpanizeBakerProperties;

    public AuthenticationServices(SlurpanizeBakerProperties slurpanizeBakerProperties) {
        this.slurpanizeBakerProperties = slurpanizeBakerProperties;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    public String authenticateUser(String username, String password) {
        if (!Objects.equals(this.slurpanizeBakerProperties.security().adminUsername(), username) ||
                !this.passwordEncoder.matches(password, this.slurpanizeBakerProperties.security().adminPassword())
        ) {
            throw new UnauthorizedException("Invalid administration credentials");
        }

        return Jwt.issuer(this.slurpanizeBakerProperties.security().jwtIssuer())
                .groups(Collections.singleton("SUPER_ADMIN"))
                .issuedAt(Instant.now())
                .expiresIn(Duration.ofMinutes(20))
                .subject(username)
                .sign();
    }
}
