package com.vedantbhosle.springbootlearning.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController //it defines two thing 1.this is controller and it is a component 2.it will always return response body
public class HelloController {

//    @RequestMapping(value = "/",method = RequestMethod.GET)
    //instead of doing this like mentioning all time like request type we can use getmapping

@Value("${welcome.message}") //this is coming from application properties
private String welcomeMessage;

    @GetMapping("/")
    public String HelloWorld() {
     return  welcomeMessage;
    }
}
