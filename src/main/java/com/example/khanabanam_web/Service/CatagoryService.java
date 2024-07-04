package com.example.khanabanam_web.Service;

import com.example.khanabanam_web.Entity.Catagory;
import com.example.khanabanam_web.Pojo.CatagoryPojo;

import java.util.List;

public interface CatagoryService {
    Catagory getCatagoryById(Integer id);
    Catagory updateCatagory(Integer id, CatagoryPojo catagoryPojo);
    void deleteCatagory(Integer id);
    void saveCatagory(CatagoryPojo catagoryPojo);
    List<Catagory> getAllCatagories();
    CatagoryPojo getCatagoryByName(String catagoryName);
    CatagoryPojo getCatagoryByid(String catagoryName);
    CatagoryPojo updateCatagory(String catagoryName, CatagoryPojo updatedCatagoryPojo);
    void deleteCatagory(String catagoryName);
}
