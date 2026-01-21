package com.ust.springbootmodularbackend.property.api;

import com.ust.springbootmodularbackend.property.model.Property;
import com.ust.springbootmodularbackend.property.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Component
@RestController
@RequestMapping("/api/v1/property")
public class PropertyController {

    @Autowired
    private PropertyService propertyService;

    @PostMapping
    public void addProperty(@RequestBody Property property){
        propertyService.addProperty(property);
    }

    @GetMapping
    public List<Property> getProperties(){
        return propertyService.getProperties();
    }

}
