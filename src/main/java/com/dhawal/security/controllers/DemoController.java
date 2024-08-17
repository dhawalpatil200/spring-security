package com.dhawal.security.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @GetMapping("/")
    public String demoApi() {
        return "Hello world...";
    }

    @GetMapping("/user")
    public String user() {
        return "Hello user";
    }

    @GetMapping("/admin")
    public String admin() {
        return "Hello admin";
    }
}
