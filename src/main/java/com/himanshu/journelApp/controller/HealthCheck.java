package com.himanshu.journelApp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthCheck {
    @GetMapping("/healthCheck")
    public String healthcheck()
    {
        return "ok";
    }
}
