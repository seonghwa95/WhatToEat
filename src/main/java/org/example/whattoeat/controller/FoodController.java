package org.example.whattoeat.controller;

import lombok.RequiredArgsConstructor;
import org.example.whattoeat.entity.FoodCategory;
import org.example.whattoeat.service.FoodService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController("/api")
@RequiredArgsConstructor
public class FoodController {

    private final FoodService foodService;

    @GetMapping("/categories")
    public ResponseEntity<List<String>> getAllFoodCategories() {
        List<String> foodCategories = new ArrayList<>();

        Class categories = FoodCategory.class;
        foodCategories.add(Arrays.toString(categories.getEnumConstants()));

        return new ResponseEntity<>(foodCategories, HttpStatus.OK);
    }
}
