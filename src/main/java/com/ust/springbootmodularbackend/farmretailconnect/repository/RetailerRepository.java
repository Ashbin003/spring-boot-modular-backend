package com.ust.springbootmodularbackend.farmretailconnect.repository;

import com.ust.springbootmodularbackend.farmretailconnect.model.Retailer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RetailerRepository extends JpaRepository<Retailer, Long> {
}
