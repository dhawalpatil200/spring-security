package com.dhawal.security.service;

import com.dhawal.security.models.Transaction;
import com.dhawal.security.repository.TransactionRepository;
import com.dhawal.security.utils.TransactionType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Override
    public List<Transaction> getAllTransactionsByUserId(Long userId) {
        return transactionRepository.findByUser_UserId(userId);
    }

    @Override
    public List<Transaction> getAllIncomeTransactionsByUserId(Long userId) {
        return transactionRepository.findByUser_UserIdAndType(userId, TransactionType.INCOME);
    }

    @Override
    public List<Transaction> getAllExpenseTransactionsByUserId(Long userId) {
        return transactionRepository.findByUser_UserIdAndType(userId, TransactionType.EXPENSE);
    }

    @Override
    public Transaction createTransaction(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    @Override
    public Transaction getTransactionByIdAndUserId(Long transactionId, Long userId) {
        Optional<Transaction> transactionOpt = transactionRepository.findById(transactionId);
        if(transactionOpt.isEmpty()) {
            throw new RuntimeException("not found");
        }

        Transaction transaction = transactionOpt.get();
        if(transaction.getUser().getUserId() != userId) {
            throw new RuntimeException("Resource not allowed to access");
        }

        return transaction;
    }

    @Override
    public boolean deleteTransactionById(Long transactionId) {
        if (transactionRepository.existsById(transactionId)) {
            transactionRepository.deleteById(transactionId);
            return true;
        }

        return false;
    }
}

