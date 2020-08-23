package com.richard.AssecoTest.view.auth;

import com.richard.AssecoTest.common.security.UserDetailsServiceAuth;
import com.richard.AssecoTest.token.TokenResponse;
import com.richard.AssecoTest.token.TokenUtil;
import com.richard.AssecoTest.view.auth.domain.UserCredentials;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping("/authenticate")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class AuthenticationController {

    private final AuthenticationManager authenticationManager;
    private final UserDetailsServiceAuth userDetailsService;
    private final TokenUtil tokenUtil;

    @PostMapping()
    public ResponseEntity<?> authenticate(@RequestBody UserCredentials userCredentials) {

        auth(userCredentials);
        final UserDetails userDetails = userDetailsService.loadUserByUsername(userCredentials.getUsername());
        final String jwtToken = tokenUtil.generateToken(userDetails);
        return ResponseEntity.ok(new TokenResponse(jwtToken));
    }

    private void auth(final UserCredentials userCredentials) {
        Objects.requireNonNull(userCredentials.getUsername());
        Objects.requireNonNull(userCredentials.getPassword());

        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(userCredentials.getUsername(), userCredentials.getPassword()));
        } catch (BadCredentialsException e) {
            throw new BadCredentialsException("Invalid credentials");
        }
    }
}
