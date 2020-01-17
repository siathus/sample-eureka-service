package com.direa.seonggook.eurekaservice.controller;

import com.netflix.config.ConfigurationManager;
import com.netflix.config.DynamicPropertyFactory;
import com.netflix.config.DynamicStringProperty;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EurekaServiceController {

    private DynamicStringProperty dynamicStringProperty;

    @GetMapping("/")
    public ResponseEntity<String> helloService() {
        dynamicStringProperty =  DynamicPropertyFactory.getInstance().getStringProperty("com.direa.seonggook.one", "not found");
        System.out.println(dynamicStringProperty);
        String body = "Hello From First Eureka Service!!";

        return new ResponseEntity<String>(body, HttpStatus.OK);
    }
}
