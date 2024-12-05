package org.example.whattoeat.entity;

import lombok.RequiredArgsConstructor;

import java.util.List;

public enum FoodCategory {
    KOREAN("한식"),
    CHINESE("중식"),
    JAPANESE("일식"),
    WESTERN("양식"),
    INDIAN("인도식"),
    MEXICAN("멕시칸");

    private final String description;

    FoodCategory(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
