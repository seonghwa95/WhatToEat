package org.example.whattoeat.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Builder
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
