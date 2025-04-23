package com.dhawal.security.service;

import com.dhawal.security.models.Category;
import com.dhawal.security.utils.TransactionType;

import java.util.List;

public interface CategoryService {

    Category findByName(String name);

    Category findById(Long id);

    List<Category> getCategoriesByType(TransactionType type);

    List<Category> getAllIncomeCategories();

    List<Category> getAllExpenseCategories();
}
