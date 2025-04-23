package com.dhawal.security.utils;

public enum TransactionType {
    INCOME,
    EXPENSE;

    public static TransactionType fromString(String type) {
        try {
            return TransactionType.valueOf(type.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid transaction type: " + type);
        }
    }
}
