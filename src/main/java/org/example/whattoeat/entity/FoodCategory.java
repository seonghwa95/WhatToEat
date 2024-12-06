package org.example.whattoeat.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@AllArgsConstructor
@RequiredArgsConstructor
public class FoodCategory {

    @Id
    @GeneratedValue
    private Long foodCategoryId;

    private String foodCategoryName;

    @OneToMany(mappedBy = "foodCategory", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Food> foods;

    public FoodCategory(String foodCategoryName) {
        this.foodCategoryName = foodCategoryName;
    }
}
