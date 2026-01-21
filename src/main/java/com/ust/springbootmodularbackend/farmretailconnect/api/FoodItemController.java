package com.ust.springbootmodularbackend.farmretailconnect.api;

import com.ust.springbootmodularbackend.farmretailconnect.model.FoodItem;
import com.ust.springbootmodularbackend.farmretailconnect.service.FoodItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Component
@RestController
@RequestMapping("food-items")
public class FoodItemController {

    @Autowired
    private FoodItemService foodItemService;

    @PostMapping
    public void addFoodItem(@RequestBody FoodItem foodItem){
        foodItemService.addFoodItem(foodItem);
    }

    @GetMapping
    public List<FoodItem> getAllFoodItems(){
        return foodItemService.getAllFoodItems();
    }

    @GetMapping("/{itemId}")
    public FoodItem getFoodItemById(@PathVariable Long itemId){
        return foodItemService.getFoodItemById(itemId);
    }

}
