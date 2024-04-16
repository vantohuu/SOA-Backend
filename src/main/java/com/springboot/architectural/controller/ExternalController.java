package com.springboot.architectural.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/external")
public class ExternalController {
    @GetMapping(value = "/verify-token-external-service")
    public ResponseEntity sayGreeting() {
        System.out.println("AAAA");
        return ResponseEntity.ok("success");
    }
}
