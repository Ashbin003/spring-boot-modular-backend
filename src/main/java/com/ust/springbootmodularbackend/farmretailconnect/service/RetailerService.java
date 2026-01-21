package com.ust.springbootmodularbackend.farmretailconnect.service;

import com.ust.springbootmodularbackend.farmretailconnect.model.Retailer;
import com.ust.springbootmodularbackend.farmretailconnect.repository.RetailerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RetailerService {

    @Autowired
    private RetailerRepository retailerRepo;

    public void addRetailer(Retailer retailer){
        retailerRepo.save(retailer);
    }

    public List<Retailer> getAllRetailers(){
        return retailerRepo.findAll();
    }

    public Retailer getRetailerById(Long retailerId){
        return retailerRepo.findById(retailerId).get();
    }

}
