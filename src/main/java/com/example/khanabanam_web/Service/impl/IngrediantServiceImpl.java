package com.example.khanabanam_web.Service.impl;

import com.example.khanabanam_web.Entity.ingrediant;
import com.example.khanabanam_web.Repository.IngrediantRepository;
import com.example.khanabanam_web.Service.IngrediantService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class IngrediantServiceImpl implements IngrediantService {

    private final IngrediantRepository ingrediantRepository;

    @Override
    public ingrediant getIngrediantById(Integer id) {
        Optional<ingrediant> optionalIngrediant = ingrediantRepository.findById(Long.valueOf(id));
        return optionalIngrediant.orElse(null);
    }

    @Override
    public ingrediant updateIngrediant(Integer id, ingrediant updatedIngrediant) {
        Optional<ingrediant> optionalIngrediant = ingrediantRepository.findById(Long.valueOf(id));
        if (optionalIngrediant.isPresent()) {
            ingrediant existingIngrediant = optionalIngrediant.get();
            existingIngrediant.setIngrediantName(updatedIngrediant.getIngrediantName());
            existingIngrediant.setIngrediantQuantity(updatedIngrediant.getIngrediantQuantity());
            existingIngrediant.setInstruction(updatedIngrediant.getInstruction());
            return ingrediantRepository.save(existingIngrediant);
        }
        return null;
    }

    @Override
    public void deleteIngrediant(Integer id) {
        ingrediantRepository.deleteById(Long.valueOf(id));
    }

    @Override
    public void saveIngrediant(ingrediant ingrediant) {
        ingrediantRepository.save(ingrediant);
    }

    @Override
    public List<ingrediant> getAllIngrediants() {
        return ingrediantRepository.findAll();
    }
}