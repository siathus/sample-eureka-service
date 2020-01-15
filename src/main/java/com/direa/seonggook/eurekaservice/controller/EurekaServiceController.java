package com.direa.seonggook.eurekaservice.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EurekaServiceController {

    @GetMapping("/")
    public ResponseEntity helloService() {

        return ResponseEntity.accepted().body("ok");
    }
}
