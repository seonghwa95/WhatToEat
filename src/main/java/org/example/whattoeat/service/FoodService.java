package org.example.whattoeat.service;

import lombok.RequiredArgsConstructor;
import org.example.whattoeat.dto.response.FoodCategoryResponse;
import org.example.whattoeat.entity.FoodCategory;
import org.example.whattoeat.repository.FoodCategoryRepository;
import org.example.whattoeat.repository.FoodRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FoodService {

    private final FoodRepository foodRepository;
    private final FoodCategoryRepository foodCategoryRepository;

    public List<FoodCategoryResponse> findAllFoodCategory() {
        List<FoodCategory> foodCategories = foodCategoryRepository.findAll();
        List<FoodCategoryResponse> foodCategoryResponses = new ArrayList<>();

        foodCategories.forEach(foodCategory -> {
            FoodCategoryResponse foodCategoryDto = FoodCategoryResponse.builder()
                    .foodCategoryId(foodCategory.getFoodCategoryId())
                    .foodCategoryName(foodCategory.getFoodCategoryName())
                    .build();

            foodCategoryResponses.add(foodCategoryDto);
        });

        return foodCategoryResponses;
    }
}
