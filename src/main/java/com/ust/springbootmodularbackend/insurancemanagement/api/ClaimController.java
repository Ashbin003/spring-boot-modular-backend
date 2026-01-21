package com.ust.springbootmodularbackend.insurancemanagement.api;

import com.ust.springbootmodularbackend.insurancemanagement.model.Claim;
import com.ust.springbootmodularbackend.insurancemanagement.service.ClaimService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Component
@RestController
@RequestMapping("/claims")
public class ClaimController {

    @Autowired
    private ClaimService claimService;

    @PostMapping
    public ResponseEntity<Claim> fileClaim(@Valid @RequestBody Claim claim){
        Claim body = claimService.fileClaim(claim);
        return ResponseEntity.status(HttpStatus.CREATED).body(body);
    }

    @GetMapping
    public ResponseEntity<List<Claim>> getClaims(){
        return ResponseEntity.ok(claimService.getAllClaims());
    }

}
