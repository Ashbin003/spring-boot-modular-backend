package com.ust.springbootmodularbackend.insurancemanagement.repository;

import com.ust.springbootmodularbackend.insurancemanagement.model.Claim;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClaimRepository extends JpaRepository<Claim, Integer> {

    boolean existsByClaimNumber(int claimNumber);


}
