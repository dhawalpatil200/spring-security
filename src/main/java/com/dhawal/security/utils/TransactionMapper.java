package com.dhawal.security.utils;

import com.dhawal.security.dto.TransactionRequest;
import com.dhawal.security.dto.TransactionResponse;
import com.dhawal.security.models.Category;
import com.dhawal.security.models.Transaction;
import com.dhawal.security.models.UserEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TransactionMapper {

    public TransactionResponse toTransactionResponse(Transaction transaction) {
        TransactionResponse response = new TransactionResponse();
        response.setTId(transaction.getTransactionId());
        response.setTitle(transaction.getTitle());
        response.setDescription(transaction.getDescription());
        response.setAmount(transaction.getAmount());
        response.setCategoryName(transaction.getCategory().getName());
        response.setCreatedAt(transaction.getCreatedAt());
        return response;
    }

    public Transaction toTransaction(TransactionRequest request, Category category, UserEntity user) {
        Transaction transaction = new Transaction();
        transaction.setTitle(request.getTitle());
        transaction.setDescription(request.getDescription());
        transaction.setAmount(request.getAmount());
        transaction.setType(category.getType());
        transaction.setCategory(category);
        transaction.setUser(user);
        return transaction;
    }

    public List<TransactionResponse> toTransactionResponseList(List<Transaction> transactions) {
        return transactions.stream()
                .map(this::toTransactionResponse)
                .collect(Collectors.toList());
    }
}
