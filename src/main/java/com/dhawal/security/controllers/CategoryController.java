package com.dhawal.security.controllers;

import com.dhawal.security.models.Category;
import com.dhawal.security.service.CategoryService;
import com.dhawal.security.utils.TransactionType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/user/categories/{type}")
    public ResponseEntity<List<Category>> getAllIncomeCategories(@PathVariable TransactionType type) {
        List<Category> categories = categoryService.getCategoriesByType(type);
        return ResponseEntity.ok(categories);
    }

}
