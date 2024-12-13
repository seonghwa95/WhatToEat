package org.example.whattoeat.controller;

import org.example.whattoeat.entity.Food;
import org.example.whattoeat.entity.FoodCategory;
import org.example.whattoeat.repository.FoodCategoryRepository;
import org.example.whattoeat.repository.FoodRepository;
import org.example.whattoeat.service.FoodService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@AutoConfigureMockMvc
@SpringBootTest
@Transactional
class FoodControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private FoodService foodService;

    @Autowired
    private FoodRepository foodRepository;

    @Autowired
    private FoodCategoryRepository foodCategoryRepository;

    @BeforeEach
    public void clean() {
        foodCategoryRepository.deleteAll();
    }

    @Test
    @DisplayName("모든 카테고리를 반환한다")
    void getAllCategories() throws Exception {
        // given
        foodCategoryRepository.save(new FoodCategory("한식"));
        foodCategoryRepository.save(new FoodCategory("양식"));

        // when
        mockMvc.perform(get("/api/categories")
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andDo(print());

        // then
        assertEquals(2L, foodCategoryRepository.count());
    }

    @Test
    @DisplayName("선택한 카테고리내에 있는 모든 음식을 반환한다")
    void getAllFoodsByCategory() throws Exception {
        // given
        foodCategoryRepository.save(new FoodCategory("한식"));
        FoodCategory foodCategory = foodCategoryRepository.findById(1L)
                .orElseThrow();
        foodRepository.save(new Food("된장찌개", foodCategory));
        foodRepository.save(new Food("김치찌개", foodCategory));

        // when
        mockMvc.perform(get("/api/categories/1")
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andDo(print());

        // then
        assertEquals(2L, foodRepository.count());
    }
}