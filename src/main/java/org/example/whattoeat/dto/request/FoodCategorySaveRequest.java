package org.example.whattoeat.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.whattoeat.entity.FoodCategory;

@Getter
@Setter
@NoArgsConstructor
public class FoodCategorySaveRequest {

    @JsonProperty
    private String foodCategoryName;

    @Builder
    public FoodCategorySaveRequest(String foodCategoryName) {
        this.foodCategoryName = foodCategoryName;
    }

    public FoodCategory toEntity() {
        return FoodCategory.builder()
                .foodCategoryName(foodCategoryName)
                .build();
    }
}
