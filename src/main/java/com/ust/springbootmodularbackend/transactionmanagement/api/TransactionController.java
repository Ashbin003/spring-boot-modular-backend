package com.ust.springbootmodularbackend.transactionmanagement.api;

import com.ust.springbootmodularbackend.transactionmanagement.model.Transaction;
import com.ust.springbootmodularbackend.transactionmanagement.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Component
@RestController
@RequestMapping("/api/v1/transactions")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @PostMapping
    public void addTransaction(@RequestBody Transaction transaction){
        transactionService.saveTransaction(transaction);
    }

    @GetMapping
    public List<Transaction> getTransactions(){
        return transactionService.getTransactions();
    }

    @GetMapping("/{id}")
    public Transaction getTransactionById(Integer id){
        return transactionService.loadTransactionById(id);
    }

}
