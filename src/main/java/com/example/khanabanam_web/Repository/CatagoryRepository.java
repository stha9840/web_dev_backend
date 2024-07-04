package com.example.khanabanam_web.Repository;


import com.example.khanabanam_web.Entity.Catagory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CatagoryRepository extends JpaRepository<Catagory, Long> {
    // You can define custom query methods here if needed
}