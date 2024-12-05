package org.example.whattoeat.service;

import lombok.RequiredArgsConstructor;
import org.example.whattoeat.entity.Food;
import org.example.whattoeat.repository.FoodRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FoodService {

    private final FoodRepository foodRepository;
}
