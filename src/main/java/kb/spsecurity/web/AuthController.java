package kb.spsecurity.web;

import kb.spsecurity.util.Constants;
import kb.spsecurity.util.JwtUtils;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final JwtUtils jwtUtils;

    public AuthController(AuthenticationManager authenticationManager,
                          JwtUtils jwtUtils) {
        this.authenticationManager = authenticationManager;
        this.jwtUtils = jwtUtils;
    }

    @PostMapping("/login")
    public Map<String, String> login(@RequestBody Map<String, String> credentials) {
        Authentication authentication =
                authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(credentials.get(Constants.USER_NAME),
                        credentials.get(Constants.PASSWORD)));
        String token = jwtUtils.generateToken(authentication.getName());
        return Map.of(Constants.TOKEN, token);
    }
}