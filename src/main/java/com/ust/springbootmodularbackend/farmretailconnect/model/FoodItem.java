package com.ust.springbootmodularbackend.farmretailconnect.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class FoodItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long itemId;
    private String itemName;
    private String type;
    @ManyToOne
    @JoinColumn(name = "retailer_id", nullable = false)
    @JsonBackReference
    @NotNull
    private Retailer retailer;

}