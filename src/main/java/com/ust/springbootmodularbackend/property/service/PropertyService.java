package com.ust.springbootmodularbackend.property.service;

import com.ust.springbootmodularbackend.property.model.Property;
import com.ust.springbootmodularbackend.property.repository.PropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PropertyService {

    @Autowired
    private PropertyRepository productRepo;

    public void addProperty(Property property){
        productRepo.saveProperty(property);
    }

    public List<Property> getProperties(){
        return productRepo.getProperties();
    }

}
