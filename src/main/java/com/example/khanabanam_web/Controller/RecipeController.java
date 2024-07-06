package com.example.khanabanam_web.Controller;

import com.example.khanabanam_web.Entity.Recipe;
import com.example.khanabanam_web.Service.RecipeService;
import com.example.khanabanam_web.shared.pojo.GlobalApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/recipes")
@RequiredArgsConstructor
public class RecipeController {

    private final RecipeService recipeService;

    @GetMapping
    public GlobalApiResponse<List<Recipe>> getAllRecipes() {
        List<Recipe> recipes = recipeService.getAllRecipes();
        return GlobalApiResponse.<List<Recipe>>builder()
                .data(recipes)
                .statusCode(200)
                .message("Success")
                .build();
    }

    @GetMapping("/{id}")
    public GlobalApiResponse<Recipe> getRecipeById(@PathVariable Integer id) {
        Recipe recipe = recipeService.getRecipeById(id);
        if (recipe != null) {
            return GlobalApiResponse.<Recipe>builder()
                    .data(recipe)
                    .statusCode(200)
                    .message("Success")
                    .build();
        } else {
            return GlobalApiResponse.<Recipe>builder()
                    .statusCode(200) // Setting status code directly to 200
                    .message("Recipe not found")
                    .build();
        }
    }

    @PostMapping
    public GlobalApiResponse<Recipe> createRecipe(@RequestBody Recipe recipe) {
        Recipe createdRecipe = recipeService.saveRecipe(recipe);
        return GlobalApiResponse.<Recipe>builder()
                .data(createdRecipe)
                .statusCode(200)
                .message("Recipe created successfully")
                .build();
    }

    @PutMapping("/{id}")
    public GlobalApiResponse<Recipe> updateRecipe(@PathVariable Integer id, @RequestBody Recipe recipe) {
        Recipe existingRecipe = recipeService.getRecipeById(id);
        if (existingRecipe != null) {
            recipe.setId(id); // Ensure the ID is set for update
            Recipe updatedRecipe = recipeService.saveRecipe(recipe);
            return GlobalApiResponse.<Recipe>builder()
                    .data(updatedRecipe)
                    .statusCode(200)
                    .message("Recipe updated successfully")
                    .build();
        } else {
            return GlobalApiResponse.<Recipe>builder()
                    .statusCode(200) // Setting status code directly to 200
                    .message("Recipe not found")
                    .build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRecipe(@PathVariable Integer id) {
        Recipe existingRecipe = recipeService.getRecipeById(id);
        if (existingRecipe != null) {
            recipeService.deleteRecipe(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

