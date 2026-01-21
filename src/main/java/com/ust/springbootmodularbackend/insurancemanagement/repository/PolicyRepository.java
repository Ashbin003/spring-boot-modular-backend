package com.ust.springbootmodularbackend.insurancemanagement.repository;

import com.ust.springbootmodularbackend.insurancemanagement.model.Policy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PolicyRepository extends JpaRepository<Policy, Integer> {

    boolean existsByPolicyNumber(int policyNumber);

}
