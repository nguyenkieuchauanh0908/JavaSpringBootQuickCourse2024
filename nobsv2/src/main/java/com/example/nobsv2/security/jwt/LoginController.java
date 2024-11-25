package com.example.nobsv2.security.jwt;

import com.example.nobsv2.mappings.Customer;
import com.example.nobsv2.security.CustomUser;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    private final AuthenticationManager manager;

    public LoginController(AuthenticationManager manager) {
        this.manager = manager;
    }

    //If the credential is valid, return jwtToken as a response to the user
    @PostMapping("/login")
    public ResponseEntity<String> login (@RequestBody CustomUser user){
        //this token is different than a json web token
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(
                user.getUsername(),
                user.getPassword()
        );

        //this will fault if the credential is not valid
        Authentication authentication = manager.authenticate(token);
        SecurityContextHolder.getContext().setAuthentication(authentication);

        //pass in authentication.principal but have to cast it into user
        String jwtToken = jwtUtil.generateToken((User) authentication.getPrincipal());
        return ResponseEntity.ok(jwtToken);
    }
}
