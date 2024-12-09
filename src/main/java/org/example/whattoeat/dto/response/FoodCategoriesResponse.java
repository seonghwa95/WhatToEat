package org.example.whattoeat.dto.response;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class FoodCategoriesResponse {

    private Long foodCategoryId;
    private String foodCategoryName;
}
