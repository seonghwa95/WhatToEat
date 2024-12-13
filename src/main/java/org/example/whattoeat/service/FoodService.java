package org.example.whattoeat.service;

import lombok.RequiredArgsConstructor;
import org.example.whattoeat.dto.request.FoodCategorySaveRequest;
import org.example.whattoeat.dto.response.FoodsByCategoryResponse;
import org.example.whattoeat.dto.response.FoodCategoriesResponse;
import org.example.whattoeat.entity.Food;
import org.example.whattoeat.entity.FoodCategory;
import org.example.whattoeat.repository.FoodCategoryRepository;
import org.example.whattoeat.repository.FoodRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FoodService {

    private final FoodRepository foodRepository;
    private final FoodCategoryRepository foodCategoryRepository;

    public List<FoodCategoriesResponse> findAllFoodCategory() {
        List<FoodCategory> foodCategories = foodCategoryRepository.findAll();
        List<FoodCategoriesResponse> foodCategoryResponses = new ArrayList<>();

        foodCategories.forEach(foodCategory -> {
            FoodCategoriesResponse foodCategoryDto = FoodCategoriesResponse.builder()
                    .foodCategoryId(foodCategory.getFoodCategoryId())
                    .foodCategoryName(foodCategory.getFoodCategoryName())
                    .build();

            foodCategoryResponses.add(foodCategoryDto);
        });

        return foodCategoryResponses;
    }

    public void addFoodCategory(FoodCategorySaveRequest request) {
        FoodCategory foodCategory = request.toEntity();

        foodCategoryRepository.save(foodCategory);
    }

    public List<FoodsByCategoryResponse> findAllFoodByCategory(Long categoryId) {
        FoodCategory foodCategory = foodCategoryRepository.findById(categoryId)
                .orElseThrow(() -> new IllegalStateException("존재하지 않는 음식 카테고리"));
        List<Food> foodsByCategory = foodRepository.findAllByFoodCategory(foodCategory);

        List<FoodsByCategoryResponse> foodsByCategoryResponses = new ArrayList<>();
        foodsByCategory.forEach(foodByCategory -> {
            FoodsByCategoryResponse foodsByCategoryResponse = FoodsByCategoryResponse.builder()
                    .foodId(foodByCategory.getFoodId())
                    .foodName(foodByCategory.getFoodName())
                    .build();

            foodsByCategoryResponses.add(foodsByCategoryResponse);
        });
        return foodsByCategoryResponses;
    }
}
