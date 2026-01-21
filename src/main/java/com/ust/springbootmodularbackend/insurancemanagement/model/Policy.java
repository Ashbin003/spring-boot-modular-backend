package com.ust.springbootmodularbackend.insurancemanagement.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
public class Policy {

    @Id
    @GeneratedValue(strategy =GenerationType.AUTO)
    @Column(name = "policy_id")
    private Long policyId;
    @Column(unique = true)
    @NotNull
    private int policyNumber;
    @NotBlank
    private String type;
    @NotNull
    private double coverageAmount;
    @NotNull
    private double premium;
    @NotBlank
    private String holderName;
    @NotBlank
    private String holderAddress;
    @NotNull
    private long holderContactNumber;
    @NotBlank
    private String holderEmail;
    @OneToMany(mappedBy = "policy", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    @NotNull
    private List<Claim> claims;

}
