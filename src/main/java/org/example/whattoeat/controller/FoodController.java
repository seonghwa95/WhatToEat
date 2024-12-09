package org.example.whattoeat.controller;

import lombok.RequiredArgsConstructor;
import org.example.whattoeat.dto.response.FoodCategoriesResponse;
import org.example.whattoeat.dto.response.FoodsByCategoryResponse;
import org.example.whattoeat.service.FoodService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("/api")
@RequiredArgsConstructor
public class FoodController {

    private final FoodService foodService;

    @GetMapping("/categories")
    public ResponseEntity<List<FoodCategoriesResponse>> getAllFoodCategories() {
        List<FoodCategoriesResponse> foodCategories = foodService.findAllFoodCategory();

        return new ResponseEntity<>(foodCategories, HttpStatus.OK);
    }

    @GetMapping("/categories/{categoryId}")
    public ResponseEntity<List<FoodsByCategoryResponse>> getAllFoodsInCategory(@PathVariable Long categoryId) {
        List<FoodsByCategoryResponse> foodsByCategory = foodService.findAllFoodByCategory(categoryId);

        return new ResponseEntity<>(foodsByCategory, HttpStatus.OK);
    }
}
