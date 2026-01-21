package com.ust.springbootmodularbackend.insurancemanagement.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Entity
@NoArgsConstructor
public class Claim {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "claim_id")
    private int claimId;
    @Column(unique = true)
    @NotNull
    private int claimNumber;
    @NotNull
    private LocalDate claimDate;
    @NotNull
    private double claimAmount;
    @NotBlank
    private String description;
    @ManyToOne
    @JoinColumn(name = "policy_id", nullable = false)
    @JsonBackReference
    @NotNull
    private Policy policy;

}
