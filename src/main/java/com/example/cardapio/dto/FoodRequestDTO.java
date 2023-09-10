package com.example.cardapio.dto;

import com.example.cardapio.entity.Food;

public record FoodRequestDTO (String title, String image, Integer price) {
    public FoodRequestDTO (Food food){
        this(food.getTitle(), food.getImage(), food.getPrice());
    }
}
