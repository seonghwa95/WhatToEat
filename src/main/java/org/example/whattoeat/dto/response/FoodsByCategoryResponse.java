package org.example.whattoeat.dto.response;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class FoodsByCategoryResponse {

    private Long foodId;
    private String foodName;
}
