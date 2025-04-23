package com.dhawal.security.service;

import com.dhawal.security.models.Category;
import com.dhawal.security.repository.CategoryRepository;
import com.dhawal.security.utils.TransactionType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Category findByName(String name) {
        return categoryRepository.findByName(name)
                .orElseThrow(() -> new RuntimeException("Category not found: " + name));
    }

    @Override
    public Category findById(Long id) {
        return categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found of id : " + id));
    }

    @Override
    public List<Category> getCategoriesByType(TransactionType type) {
        return categoryRepository.findByType(type);
    }

    @Override
    public List<Category> getAllIncomeCategories() {
        return categoryRepository.findByType(TransactionType.INCOME);
    }

    @Override
    public List<Category> getAllExpenseCategories() {
        return categoryRepository.findByType(TransactionType.EXPENSE);
    }
}
