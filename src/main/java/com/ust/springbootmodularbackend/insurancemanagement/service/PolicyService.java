package com.ust.springbootmodularbackend.insurancemanagement.service;

import com.ust.springbootmodularbackend.insurancemanagement.exceptions.DuplicatePolicyException;
import com.ust.springbootmodularbackend.insurancemanagement.exceptions.PolicyNotFoundException;
import com.ust.springbootmodularbackend.insurancemanagement.model.Claim;
import com.ust.springbootmodularbackend.insurancemanagement.model.Policy;
import com.ust.springbootmodularbackend.insurancemanagement.repository.PolicyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PolicyService {

    @Autowired
    private PolicyRepository policyRepo;

    public Policy addPolicy(Policy policy) {

        if (policyRepo.existsByPolicyNumber(policy.getPolicyNumber())) {
            throw new DuplicatePolicyException("Policy with number " + policy.getPolicyNumber() + " already exists");
        }

        if (policy.getClaims() != null) {
            for (Claim claim : policy.getClaims()) {
                claim.setPolicy(policy);
            }
        }

        return policyRepo.save(policy);
    }


    public List<Policy> getAllPolicies(){
        return policyRepo.findAll();
    }

    public void deletePolicy(Long policyId){
        Policy p = policyRepo.findById(Math.toIntExact(policyId)).orElseThrow(() -> new PolicyNotFoundException("Policy with id: " + policyId + " is not found!"));
        policyRepo.delete(p);
    }

}
