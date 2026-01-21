package com.ust.springbootmodularbackend.transactionmanagement.model;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Transaction {

    private int id;
    private double amount;
    @Enumerated(EnumType.STRING)
    private Status status;

}
