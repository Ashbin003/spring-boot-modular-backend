package com.ust.springbootmodularbackend.property.repository;

import com.ust.springbootmodularbackend.property.model.Property;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PropertyRepository {

    private List<Property> properties = new ArrayList<>();

    public void saveProperty(Property property){
        properties.add(property);
    }

    public List<Property> getProperties(){
        return properties;
    }

}
