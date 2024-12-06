package org.example.whattoeat.controller;

import lombok.RequiredArgsConstructor;
import org.example.whattoeat.dto.response.FoodCategoryResponse;
import org.example.whattoeat.service.FoodService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("/api")
@RequiredArgsConstructor
public class FoodController {

    private final FoodService foodService;

    @GetMapping("/categories")
    public ResponseEntity<List<FoodCategoryResponse>> getAllFoodCategories() {
        List<FoodCategoryResponse> foodCategories = foodService.findAllFoodCategory();

        return new ResponseEntity<>(foodCategories, HttpStatus.OK);
    }
}
