package org.example.whattoeat.controller;

import jakarta.persistence.EntityManager;
import org.example.whattoeat.dto.response.FoodCategoryResponse;
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

import java.util.List;

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

        // when
        mockMvc.perform(get("/categories")
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andDo(print());

        // then
        assertEquals(1L, foodCategoryRepository.count());
    }
}