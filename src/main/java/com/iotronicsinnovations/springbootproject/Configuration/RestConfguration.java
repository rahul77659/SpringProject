package com.iotronicsinnovations.springbootproject.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration   // now it will look for bean aannotation
public class RestConfguration {
    @Bean // it will now return the object as below
    public RestTemplate restTemplate (){
        return new RestTemplate();
    }
}
