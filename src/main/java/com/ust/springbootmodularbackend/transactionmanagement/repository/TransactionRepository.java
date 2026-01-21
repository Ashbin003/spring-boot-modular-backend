package com.ust.springbootmodularbackend.transactionmanagement.repository;

import com.ust.springbootmodularbackend.transactionmanagement.model.Transaction;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TransactionRepository {

    private List<Transaction> transactions = new ArrayList<>();

    public void addTransaction(Transaction transaction){
        transactions.add(transaction);
    }

    public List<Transaction> getTransactions(){
        return transactions;
    }

    public Transaction getTransactionById(Integer id){
        return transactions.stream().filter(t -> t.getId() == id).findFirst().orElseThrow(() -> new RuntimeException("The transaction with id: " + id + " does not exist!"));
    }

}
