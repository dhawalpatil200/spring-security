package com.dhawal.security.controllers;

import com.dhawal.security.dto.TransactionRequest;
import com.dhawal.security.dto.TransactionResponse;
import com.dhawal.security.models.Category;
import com.dhawal.security.models.Transaction;
import com.dhawal.security.models.UserEntity;
import com.dhawal.security.service.CategoryService;
import com.dhawal.security.service.TransactionService;
import com.dhawal.security.service.UserService;
import com.dhawal.security.utils.TransactionMapper;
import com.dhawal.security.utils.TransactionType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user/transactions")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private UserService userService;

    @Autowired
    private TransactionMapper transactionMapper;

    @GetMapping
    public ResponseEntity<List<TransactionResponse>> getAllTransactionsByUserId(@RequestAttribute Long userId) {
        List<Transaction> transactions = transactionService.getAllTransactionsByUserId(userId);
        return ResponseEntity.ok(transactionMapper.toTransactionResponseList(transactions));
    }

    @GetMapping("/income")
    public ResponseEntity<List<TransactionResponse>> getAllIncomeTransactionsByUserId(@RequestAttribute Long userId) {
        List<Transaction> incomeTransactions = transactionService.getAllIncomeTransactionsByUserId(userId);
        return ResponseEntity.ok(transactionMapper.toTransactionResponseList(incomeTransactions));
    }

    @GetMapping("/expense")
    public ResponseEntity<List<TransactionResponse>> getAllExpenseTransactionsByUserId(@RequestAttribute Long userId) {
        List<Transaction> expenseTransactions = transactionService.getAllExpenseTransactionsByUserId(userId);
        return ResponseEntity.ok(transactionMapper.toTransactionResponseList(expenseTransactions));
    }

    @PostMapping
    public ResponseEntity<TransactionResponse> createTransaction(@RequestBody TransactionRequest request, @RequestAttribute Long userId) {
        Category category = categoryService.findById(request.getCategoryId());
        UserEntity userEntity = userService.findByUserId(userId);

        Transaction transaction = transactionMapper.toTransaction(request, category, userEntity);
        Transaction savedTransaction = transactionService.createTransaction(transaction);
        TransactionResponse response = transactionMapper.toTransactionResponse(savedTransaction);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }


    @GetMapping("/{transactionId}")
    public ResponseEntity<TransactionResponse> getTransactionById(@PathVariable Long transactionId, @RequestAttribute Long userId) {
        Transaction transaction = transactionService.getTransactionByIdAndUserId(transactionId, userId);
        if (transaction == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        TransactionResponse response = transactionMapper.toTransactionResponse(transaction);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{transactionId}")
    public ResponseEntity<String> deleteTransactionByID(@PathVariable Long transactionId) {
        boolean isDeleted = transactionService.deleteTransactionById(transactionId);

        if (isDeleted) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Transaction deleted successfully");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Transaction not found");
        }
    }


}
