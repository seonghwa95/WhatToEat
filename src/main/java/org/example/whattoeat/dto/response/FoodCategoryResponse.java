package org.example.whattoeat.dto.response;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class FoodCategoryResponse {

    private Long foodCategoryId;
    private String foodCategoryName;
}
