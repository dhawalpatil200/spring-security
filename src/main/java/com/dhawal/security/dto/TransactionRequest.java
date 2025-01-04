package com.dhawal.security.dto;

import com.dhawal.security.models.Category;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TransactionRequest {
    private String title;
    private String description;
    private Double amount;
    private Long categoryId;

}