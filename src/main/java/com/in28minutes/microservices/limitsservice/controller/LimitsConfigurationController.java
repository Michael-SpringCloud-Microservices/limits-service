package com.in28minutes.microservices.limitsservice.controller;

import com.in28minutes.microservices.limitsservice.configuration.Configuration;
import com.in28minutes.microservices.limitsservice.model.LimitsConfiguration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LimitsConfigurationController {


    @Autowired
    Configuration configuration;

    @Value("${minimum}")
    private int minimum;

    @Value("${maximum}")
    private int maximum;

    @GetMapping("/limits")
    public LimitsConfiguration retrieveLimitsFromConfiguration() {
        // The following line will refer properties from git based file system via Spring cloud config server
        return new LimitsConfiguration(maximum, minimum);

    }
    
    @GetMapping("/limits/via-propety-file")
    public LimitsConfiguration retrieveLimitsFromPropertyFile() {
       return new LimitsConfiguration(configuration.getMaximum(),configuration.getMinimum());

    }
}
