package com.example.khanabanam_web.Controller;

import com.example.khanabanam_web.Entity.Catagory;
import com.example.khanabanam_web.Pojo.CatagoryPojo;
import com.example.khanabanam_web.Service.CatagoryService;
import com.example.khanabanam_web.shared.pojo.GlobalApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/catagory")
@RequiredArgsConstructor
public class CatagoryController {

    private final CatagoryService catagoryService;

    @PostMapping
    public GlobalApiResponse<String> saveCatagory(@RequestBody CatagoryPojo catagoryPojo) {
        catagoryService.saveCatagory(catagoryPojo);
        return GlobalApiResponse.<String>builder()
                .data("Saved")
                .statusCode(200)
                .message("Catagory saved successfully")
                .build();
    }

    @GetMapping
    public GlobalApiResponse<List<Catagory>> getAllCatagories() {
        List<Catagory> catagories = catagoryService.getAllCatagories();
        return GlobalApiResponse.<List<Catagory>>builder()
                .data(catagories)
                .statusCode(200)
                .message("Catagories retrieved successfully")
                .build();
    }

    @GetMapping("/{id}")
    public GlobalApiResponse<Catagory> getCatagoryById(@PathVariable Integer id) {
        Catagory catagory = catagoryService.getCatagoryById(id);
        if (catagory != null) {
            return GlobalApiResponse.<Catagory>builder()
                    .data(catagory)
                    .statusCode(200)
                    .message("Catagory found with id: " + id)
                    .build();
        } else {
            return GlobalApiResponse.<Catagory>builder()
                    .statusCode(404)
                    .message("Catagory not found with id: " + id)
                    .build();
        }
    }

    @PutMapping("/{id}")
    public GlobalApiResponse<String> updateCatagory(@PathVariable Integer id, @RequestBody CatagoryPojo catagoryPojo) {
        Catagory updatedCatagory = catagoryService.updateCatagory(id, catagoryPojo);
        if (updatedCatagory != null) {
            return GlobalApiResponse.<String>builder()
                    .data("Updated")
                    .statusCode(200)
                    .message("Catagory updated successfully")
                    .build();
        } else {
            return GlobalApiResponse.<String>builder()
                    .statusCode(404)
                    .message("Catagory not found with id: " + id + ". Update failed.")
                    .build();
        }
    }

    @DeleteMapping("/{id}")
    public GlobalApiResponse<String> deleteCatagory(@PathVariable Integer id) {
        Catagory catagory = catagoryService.getCatagoryById(id);
        if (catagory != null) {
            catagoryService.deleteCatagory(id);
            return GlobalApiResponse.<String>builder()
                    .data("Deleted")
                    .statusCode(200)
                    .message("Catagory deleted successfully")
                    .build();
        } else {
            return GlobalApiResponse.<String>builder()
                    .statusCode(404)
                    .message("Catagory not found with id: " + id + ". Delete failed.")
                    .build();
        }
    }
}
