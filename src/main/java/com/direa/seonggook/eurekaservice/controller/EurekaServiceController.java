package com.direa.seonggook.eurekaservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EurekaServiceController {

    @GetMapping("/")
    public ResponseEntity helloService() {

        return new ResponseEntity<String>("Hello from Eureka Service!", HttpStatus.OK);
    }
}
