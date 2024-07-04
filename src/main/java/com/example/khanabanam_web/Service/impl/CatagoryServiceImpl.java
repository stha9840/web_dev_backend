package com.example.khanabanam_web.Service.impl;

import com.example.khanabanam_web.Entity.Catagory;
import com.example.khanabanam_web.Pojo.CatagoryPojo;
import com.example.khanabanam_web.Repository.CatagoryRepository;
import com.example.khanabanam_web.Service.CatagoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Repository
@RequiredArgsConstructor
@Service
public class CatagoryServiceImpl implements CatagoryService {

    private final CatagoryRepository catagoryRepository;

    @Override
    public Catagory getCatagoryById(Integer id) {
        Optional<Catagory> optionalCatagory = catagoryRepository.findById(Long.valueOf(id));
        return optionalCatagory.orElse(null);
    }

    @Override
    public Catagory updateCatagory(Integer id, CatagoryPojo catagoryPojo) {
        Optional<Catagory> optionalCatagory = catagoryRepository.findById(Long.valueOf(id));
        if (optionalCatagory.isPresent()) {
            Catagory existingCatagory = optionalCatagory.get();
            existingCatagory.setCatagoryName(catagoryPojo.getCatagoryName());
            return catagoryRepository.save(existingCatagory);
        }
        return null;
    }

    @Override
    public void deleteCatagory(Integer id) {
        catagoryRepository.deleteById(Long.valueOf(id));
    }

    @Override
    public void saveCatagory(CatagoryPojo catagoryPojo) {
        Catagory catagory = new Catagory();
        catagory.setCatagoryName(catagoryPojo.getCatagoryName());
        catagoryRepository.save(catagory);
    }

    @Override
    public List<Catagory> getAllCatagories() {
        return catagoryRepository.findAll();
    }

    @Override
    public CatagoryPojo getCatagoryByName(String catagoryName) {
        return null;
    }

    @Override
    public CatagoryPojo getCatagoryByid(String catagoryName) {
        return null;
    }


    @Override
    public CatagoryPojo updateCatagory(String catagoryName, CatagoryPojo updatedCatagoryPojo) {
        // Implement if needed
        return null;
    }

    @Override
    public void deleteCatagory(String catagoryName) {
        // Implement if needed
    }
}
