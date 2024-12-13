package org.example.whattoeat.controller;

import lombok.RequiredArgsConstructor;
import org.example.whattoeat.dto.request.FoodCategorySaveRequest;
import org.example.whattoeat.dto.response.FoodCategoriesResponse;
import org.example.whattoeat.dto.response.FoodsByCategoryResponse;
import org.example.whattoeat.global.response.ApiSuccessResponse;
import org.example.whattoeat.service.FoodService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class FoodController {

    private final FoodService foodService;

    @GetMapping("/categories")
    public ResponseEntity<ApiSuccessResponse<List<FoodCategoriesResponse>>> getAllFoodCategories() {
        List<FoodCategoriesResponse> foodCategoriesResponseList = foodService.findAllFoodCategory();
        ApiSuccessResponse<List<FoodCategoriesResponse>> foodCategories = ApiSuccessResponse.from(foodCategoriesResponseList);

        return new ResponseEntity<>(foodCategories, HttpStatus.OK);
    }

    @PostMapping("/categories")
    public void postFoodCategory(@RequestBody FoodCategorySaveRequest request) {
        foodService.addFoodCategory(request);
    }

    @GetMapping("/categories/{categoryId}")
    public ResponseEntity<List<FoodsByCategoryResponse>> getAllFoodsInCategory(@PathVariable Long categoryId) {
        List<FoodsByCategoryResponse> foodsByCategory = foodService.findAllFoodByCategory(categoryId);

        return new ResponseEntity<>(foodsByCategory, HttpStatus.OK);
    }
}
