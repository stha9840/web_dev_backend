package com.example.khanabanam_web.Service.impl;

import com.example.khanabanam_web.Entity.Recipe;
import com.example.khanabanam_web.Repository.RecipeRepository;
import com.example.khanabanam_web.Service.RecipeService;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class RecipeServiceImpl implements RecipeService {

    private final RecipeRepository recipeRepository;


    @Override
    public List<Recipe> getAllRecipes() {
        return recipeRepository.findAll();
    }

    @Override
    public Recipe getRecipeById(Integer id) {
        Optional<Recipe> recipeOptional = recipeRepository.findById(Long.valueOf(id));
        return recipeOptional.orElse(null);
    }

    @Override
    public Recipe saveRecipe(Recipe recipe) {
        return recipeRepository.save(recipe);
    }

    @Override
    public void deleteRecipe(Integer id) {
        recipeRepository.deleteById(Long.valueOf(id));
    }
}
