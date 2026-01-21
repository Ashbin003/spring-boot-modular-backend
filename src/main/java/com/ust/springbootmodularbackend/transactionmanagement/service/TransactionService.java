package com.ust.springbootmodularbackend.transactionmanagement.service;

import com.ust.springbootmodularbackend.transactionmanagement.model.Transaction;
import com.ust.springbootmodularbackend.transactionmanagement.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepo;

    public void saveTransaction(Transaction transaction){
        transactionRepo.addTransaction(transaction);
    }

    public List<Transaction> getTransactions(){
        return transactionRepo.getTransactions();
    }

    public Transaction loadTransactionById(Integer id){
        return transactionRepo.getTransactionById(id);
    }

}
