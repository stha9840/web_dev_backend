package com.example.khanabanam_web.Controller;

import com.example.khanabanam_web.Entity.ingrediant;
import com.example.khanabanam_web.Service.IngrediantService;
import com.example.khanabanam_web.shared.pojo.GlobalApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ingrediant")
@RequiredArgsConstructor
public class IngrediantController {

    private final IngrediantService ingrediantService;

    @GetMapping("/{id}")
    public GlobalApiResponse<ingrediant> getIngrediantById(@PathVariable Integer id) {
        ingrediant ingrediant = ingrediantService.getIngrediantById(id);
        return GlobalApiResponse.<ingrediant>builder()
                    .data(ingrediant)
                    .statusCode(200)
                    .message("Ingrediant found with id: " + id)
                    .build();
    }

    @PostMapping
    public GlobalApiResponse<String> saveIngrediant(@RequestBody ingrediant ingrediant) {
        ingrediantService.saveIngrediant(ingrediant);
        return GlobalApiResponse.<String>builder()
                .data("Saved")
                .statusCode(200)
                .message("Ingrediant saved successfully")
                .build();
    }

    @PutMapping("/{id}")
    public GlobalApiResponse<String> updateIngrediant(@PathVariable Integer id, @RequestBody ingrediant updatedIngrediant) {
        ingrediant existingIngrediant = ingrediantService.updateIngrediant(id, updatedIngrediant);
        if (existingIngrediant != null) {
            return GlobalApiResponse.<String>builder()
                    .data("Updated")
                    .statusCode(200)
                    .message("Ingrediant updated successfully")
                    .build();
        } else {
            return GlobalApiResponse.<String>builder()
                    .statusCode(404)
                    .message("Ingrediant not found with id: " + id + ". Update failed.")
                    .build();
        }
    }

    @DeleteMapping("/{id}")
    public GlobalApiResponse<String> deleteIngrediant(@PathVariable Integer id) {
        ingrediant ingrediant = ingrediantService.getIngrediantById(id);
        if (ingrediant != null) {
            ingrediantService.deleteIngrediant(id);
            return GlobalApiResponse.<String>builder()
                    .data("Deleted")
                    .statusCode(200)
                    .message("Ingrediant deleted successfully")
                    .build();
        } else {
            return GlobalApiResponse.<String>builder()
                    .statusCode(404)
                    .message("Ingrediant not found with id: " + id + ". Delete failed.")
                    .build();
        }
    }

    @GetMapping
    public GlobalApiResponse<List<ingrediant>> getAllIngrediants() {
        List<ingrediant> ingrediants = ingrediantService.getAllIngrediants();
        return GlobalApiResponse.<List<ingrediant>>builder()
                .data(ingrediants)
                .statusCode(200)
                .message("All ingrediants retrieved successfully")
                .build();
    }
}