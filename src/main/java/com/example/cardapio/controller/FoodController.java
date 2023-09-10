package com.example.cardapio.controller;

import com.example.cardapio.dto.FoodRequestDTO;
import com.example.cardapio.dto.FoodResponseDTO;
import com.example.cardapio.entity.Food;
import com.example.cardapio.repository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("food")
public class FoodController {

    @Autowired
    private FoodRepository repository;

    @GetMapping
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public List<FoodResponseDTO>  getAll(){
        List<FoodResponseDTO> foods = repository.findAll().stream().map(FoodResponseDTO::new).toList();
        return foods;
    }

    @PostMapping
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public void save(@RequestBody FoodRequestDTO data){
        Food foodData = new Food(data);
        repository.save(foodData);

    }
}
