package com.dhawal.security.controllers;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @GetMapping("/")
    public String greet(HttpServletRequest request) {
        return "Hello world " + request.getSession().getId();
    }
}
