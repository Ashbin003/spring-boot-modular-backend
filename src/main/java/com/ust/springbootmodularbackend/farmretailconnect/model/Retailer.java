package com.ust.springbootmodularbackend.farmretailconnect.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@NoArgsConstructor
public class Retailer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long retailerId;
    private String retailerName;
    private String storeLocation;
    @OneToMany(mappedBy = "retailer", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    @NotNull
    private List<FoodItem> foodItems;

}
