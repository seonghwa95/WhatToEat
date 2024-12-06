package org.example.whattoeat.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
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
}
