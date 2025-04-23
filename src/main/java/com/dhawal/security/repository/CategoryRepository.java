package com.dhawal.security.repository;

import com.dhawal.security.models.Category;
import com.dhawal.security.utils.TransactionType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    List<Category> findByType(TransactionType type);

    Optional<Category> findByName(String name);
}
