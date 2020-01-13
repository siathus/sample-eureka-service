package com.direa.seonggook.eurekaservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EurekaServiceController {

    @GetMapping("/")
    public String helloService() {

        return "hello from Eureka Service!";
    }
}
