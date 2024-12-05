package org.example.whattoeat.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Food {

    @Id
    private Long foodId;

    private FoodCategory category;

    private String imagePath;
}
