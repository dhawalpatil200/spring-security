package com.dhawal.security.repository;

import com.dhawal.security.models.Transaction;
import com.dhawal.security.utils.TransactionType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    // Find all transactions by userId
    List<Transaction> findByUser_UserId(Long userId);

    // Find all transactions by userId and transactionType (INCOME or EXPENSE)
    List<Transaction> findByUser_UserIdAndType(Long userId, TransactionType type);

}
