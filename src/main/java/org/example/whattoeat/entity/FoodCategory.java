package org.example.whattoeat.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Entity
public class FoodCategory {

    @Id
    @GeneratedValue
    private Long id;

    @OneToOne(mappedBy = "category")
    private Food food;
}
