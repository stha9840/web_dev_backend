package com.example.khanabanam_web.Repository;



import com.example.khanabanam_web.Entity.ingrediant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngrediantRepository extends JpaRepository<ingrediant, Long> {
}
