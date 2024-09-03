package com.dhawal.security.controllers;

import com.dhawal.security.models.DemoEntity;
import com.dhawal.security.service.DemoService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DemoController {

    @Autowired
    private DemoService demoService;


    @GetMapping("/")
    public String greet(HttpServletRequest request) {
        return "Hello world " + request.getSession().getId();
    }

    @GetMapping("/user/demos")
    public List<DemoEntity> getAllDemos() {
        return demoService.getAllDemos();
    }

    @GetMapping("/user/demos/{id}")
    public DemoEntity getDemoById(@PathVariable Long id) {
        return demoService.getDemoById(id);
    }

    @PostMapping("/admin/demos")
    public DemoEntity createDemo(@RequestBody DemoEntity demoEntity) {
        return demoService.createDemo(demoEntity);
    }

    @DeleteMapping("/admin/demos/{id}")
    public void deleteDemo(@PathVariable Long id) {
        demoService.deleteDemo(id);
    }
}
