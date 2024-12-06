package org.example.whattoeat.entity;

import jakarta.persistence.*;

@Entity
public class Food {

    @Id
    @GeneratedValue
    private Long id;

    @OneToOne(mappedBy = "food", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private FoodCategory category;

    private String imagePath;
}
