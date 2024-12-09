package org.example.whattoeat.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Food {

    @Id
    @GeneratedValue
    private Long foodId;

    private String foodName;

    @ManyToOne(fetch = FetchType.LAZY)
    private FoodCategory foodCategory;

    private String imagePath;

    public Food(String foodName, FoodCategory foodCategory) {
        this.foodName = foodName;
        this.foodCategory = foodCategory;
    }
}
