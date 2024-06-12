package com.iotronicsinnovations.springbootproject.Configuration;

import com.iotronicsinnovations.springbootproject.Service.FakeStoreProductService;
import com.iotronicsinnovations.springbootproject.Service.ProductService;
import com.iotronicsinnovations.springbootproject.dtos.CreateProductRequestDto;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration   // now it will look for bean aannotation
public class RestConfguration {
//    //@Bean // it will now return the object as below at the start of application
//    public RestTemplate restTemplate() {
//        return new RestTemplate();
//    }
@Bean
public RestTemplate restTemplate(){
    return new RestTemplate();
}

//    @Bean
//    public CreateProductRequestDto createProductRequestDto() {
//        return new CreateProductRequestDto();
//    }
    @Bean
    public FakeStoreProductService getProductService() {
        return new FakeStoreProductService(new RestTemplate());
    }


}