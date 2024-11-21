package com.example.nobsv2;

import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@org.springframework.context.annotation.Configuration
public class Configuration {

    @Bean
    //Beans get injected into spring container
    //will cover this in dependency injection video
    //gives us access to rest template throughout the application
    public RestTemplate  restTemplate(){
        //configure your rest template options
        return new RestTemplate();
    }
}
