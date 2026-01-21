package com.ust.springbootmodularbackend.farmretailconnect.service;

import com.ust.springbootmodularbackend.farmretailconnect.model.FoodItem;
import com.ust.springbootmodularbackend.farmretailconnect.repository.FoodItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodItemService {

    @Autowired
    private FoodItemRepository foodItemRepo;

    public void addFoodItem(FoodItem foodItem){
        foodItemRepo.save(foodItem);
    }

    public List<FoodItem> getAllFoodItems(){
        return foodItemRepo.findAll();
    }

    public FoodItem getFoodItemById(Long itemId){
        return foodItemRepo.findById(itemId).get();
    }

}
