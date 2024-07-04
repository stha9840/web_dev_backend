package com.example.khanabanam_web.Service;

import com.example.khanabanam_web.Entity.ingrediant;
import java.util.List;

public interface IngrediantService {

    ingrediant getIngrediantById(Integer id);

    ingrediant updateIngrediant(Integer id, ingrediant updatedIngrediant);

    void deleteIngrediant(Integer id);

    void saveIngrediant(ingrediant ingrediant);

    List<ingrediant> getAllIngrediants();
}