package com.dhawal.security.dto;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;


@Data
@NoArgsConstructor
public class TransactionResponse {
    private Long tId;
    private String title;
    private String description;
    private Double amount;
    private String categoryName;
    private LocalDateTime createdAt;
}
