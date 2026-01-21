package com.ust.springbootmodularbackend.farmretailconnect.api;

import com.ust.springbootmodularbackend.farmretailconnect.model.Retailer;
import com.ust.springbootmodularbackend.farmretailconnect.service.RetailerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Component
@RestController
@RequestMapping("/retailers")
public class RetailerController {

    @Autowired
    private RetailerService retailerService;

    @PostMapping
    public void addRetailer(@RequestBody Retailer retailer){
        retailerService.addRetailer(retailer);
    }

    @GetMapping
    public List<Retailer> getAllRetailers(){
        return retailerService.getAllRetailers();
    }

    @GetMapping("/{retailerId}")
    public Retailer getRetailerById(@PathVariable Long retailerId){
        return retailerService.getRetailerById(retailerId);
    }

}
