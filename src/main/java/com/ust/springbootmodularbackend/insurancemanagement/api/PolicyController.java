package com.ust.springbootmodularbackend.insurancemanagement.api;

import com.ust.springbootmodularbackend.insurancemanagement.model.Policy;
import com.ust.springbootmodularbackend.insurancemanagement.service.PolicyService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Component
@RestController
@RequestMapping("/policies")
public class PolicyController {

    @Autowired
    private PolicyService policyService;

    @PostMapping
    public ResponseEntity<Policy> addPolicy(@Valid @RequestBody Policy policy){
        Policy body = policyService.addPolicy(policy);
        return ResponseEntity.status(HttpStatus.CREATED).body(body);
    }

    @GetMapping
    public ResponseEntity<List<Policy>> getAllPolicies(){
        return ResponseEntity.ok(policyService.getAllPolicies());
    }

    @DeleteMapping("/{policyId}")
    public ResponseEntity<Void> deletPolicy(@PathVariable Long policyId){
        policyService.deletePolicy(policyId);
        return ResponseEntity.noContent().build();
    }

}
