package com.dhawal.security.service;

import com.dhawal.security.models.Transaction;

import java.util.List;

public interface TransactionService {

    List<Transaction> getAllTransactionsByUserId(Long userId);

    List<Transaction> getAllIncomeTransactionsByUserId(Long userId);

    List<Transaction> getAllExpenseTransactionsByUserId(Long userId);

    Transaction createTransaction(Transaction request);

    Transaction getTransactionByIdAndUserId(Long transactionId, Long userId);

    boolean deleteTransactionById(Long transactionId);
}
