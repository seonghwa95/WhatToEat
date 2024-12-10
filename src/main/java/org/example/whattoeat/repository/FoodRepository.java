package org.example.whattoeat.repository;

import org.example.whattoeat.entity.Food;
import org.example.whattoeat.entity.FoodCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FoodRepository extends JpaRepository<Food, Long> {

    List<Food> findAllByFoodCategory(FoodCategory foodCategory);
}
