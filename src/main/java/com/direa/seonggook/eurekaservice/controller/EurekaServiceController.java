package com.direa.seonggook.eurekaservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EurekaServiceController {

    @GetMapping("/")
    public ResponseEntity helloService() {

        String body = "";
        if (Math.random() > 0.5) {
            body = "First Hello";
        } else {
            body = "Second Hello";
        }
//        return new ResponseEntity<String>("Hello from Eureka Service!", HttpStatus.OK);
        return new ResponseEntity<String>(body, HttpStatus.OK);
    }
}
