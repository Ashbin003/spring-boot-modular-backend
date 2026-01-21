package com.ust.springbootmodularbackend.property.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Property {

    private int id;
    private String address;
    private String description;

}
