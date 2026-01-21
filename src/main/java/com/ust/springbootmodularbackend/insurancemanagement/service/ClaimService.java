package com.ust.springbootmodularbackend.insurancemanagement.service;

import com.ust.springbootmodularbackend.insurancemanagement.model.Claim;
import com.ust.springbootmodularbackend.insurancemanagement.model.Policy;
import com.ust.springbootmodularbackend.insurancemanagement.repository.ClaimRepository;
import com.ust.springbootmodularbackend.insurancemanagement.repository.PolicyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClaimService {

    @Autowired
    private ClaimRepository claimRepo;
    @Autowired
    private PolicyRepository policyRepository;

    public Claim fileClaim(Claim claim) {

        // 1️⃣ Check if claim already exists
        if (claimRepo.existsByClaimNumber(claim.getClaimNumber())) {
            throw new RuntimeException(
                    "Claim with number " + claim.getClaimNumber() + " already exists"
            );
        }

        // 2️⃣ Extract policyId safely
        if (claim.getPolicy() == null || claim.getPolicy().getPolicyId() == null) {
            throw new RuntimeException("Policy must not be null");
        }

        Long policyId = claim.getPolicy().getPolicyId();

        // 3️⃣ Fetch existing policy
        Policy policy = policyRepository.findById(Math.toIntExact(policyId))
                .orElseThrow(() ->
                        new RuntimeException("Policy with id " + policyId + " not found")
                );

        // 4️⃣ Attach managed policy entity
        claim.setPolicy(policy);

        // 5️⃣ Save claim
        return claimRepo.save(claim);
    }


    public List<Claim> getAllClaims(){
        return claimRepo.findAll();
    }

}
