package com.iotronicsinnovations.springbootproject;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyFirstApp {
    @RequestMapping("/hello")
    public String sayHello(){
        return "Hello! rahul Welcome to first Spring Boot Application";
    }
    @RequestMapping("/hello/{name}")
    public String SayHelloWithName(@PathVariable("name") String personName){
        return "Hello "+personName+"!  Welcome to Spring Boot World ";
    }
    @RequestMapping("/hello/h/{name}")
    public String SayHelloWithName3(@PathVariable("name") String personName){
        return "Hello "+personName+"!  Welcome to Spring Boot World Hello h ";
    }
}
