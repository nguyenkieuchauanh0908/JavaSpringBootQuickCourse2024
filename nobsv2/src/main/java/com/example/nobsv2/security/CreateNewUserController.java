package com.example.nobsv2.security;

import com.example.nobsv2.mappings.Customer;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class CreateNewUserController {
    private final PasswordEncoder encoder;

    private final CustomUserRepository customUserRepository;


    public CreateNewUserController(PasswordEncoder encoder, CustomUserRepository customUserRepository) {
        this.encoder = encoder;
        this.customUserRepository = customUserRepository;
    }

    @PostMapping("/createnewuser")
    public ResponseEntity<String> createNewUser(@RequestBody CustomUser user){
        //this should be in a service class -> keep it simple here
        //error handling is skiped to focus on security

        Optional<CustomUser> optionalUser = customUserRepository.findById(user.getUsername());
        System.out.println("Checking if user already exist!" + user);

        if(optionalUser.isEmpty()){
            System.out.println("Saving user");
            customUserRepository.save(new CustomUser(user.getUsername(), encoder.encode(user.getPassword())));
            return ResponseEntity.ok("Success");
        }
        System.out.println("User exist!");
        return ResponseEntity.badRequest().body("Failure");
    }
}
