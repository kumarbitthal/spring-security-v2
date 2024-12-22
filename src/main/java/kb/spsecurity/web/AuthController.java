package kb.spsecurity.web;

import kb.spsecurity.dto.ApiResponse;
import kb.spsecurity.dto.AuthRequest;
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
    public ApiResponse<Map<String, String>> login(@RequestBody AuthRequest authRequest) {
        Authentication authentication =
                authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(),
                        authRequest.getPassword()));

        String token = jwtUtils.generateToken(authentication.getName());

        Map<String, String> responseData = Map.of(Constants.TOKEN, token);
        ApiResponse<Map<String, String>> response = new ApiResponse<>(responseData, true);
        return response;
    }
}