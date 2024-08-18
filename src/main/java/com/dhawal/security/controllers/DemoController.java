package com.dhawal.security.controllers;

import com.dhawal.security.models.User;
import com.dhawal.security.repository.UserRepository;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DemoController {

    @Autowired
    private UserRepository userRepository;


    @GetMapping("/")
    public String greet(HttpServletRequest request) {
        return "Hello world " + request.getSession().getId();
    }

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
