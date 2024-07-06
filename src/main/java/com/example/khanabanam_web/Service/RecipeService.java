package com.example.khanabanam_web.Service;

import com.example.khanabanam_web.Entity.Recipe;

import java.util.List;

public interface RecipeService {

    List<Recipe> getAllRecipes();

    Recipe getRecipeById(Integer id);

    Recipe saveRecipe(Recipe recipe);

    void deleteRecipe(Integer id);
}
