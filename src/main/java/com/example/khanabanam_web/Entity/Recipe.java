package com.example.khanabanam_web.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "Recpie")

public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "recipe_seq_gen")
    @SequenceGenerator(name = "recipe_seq_gen", sequenceName = "recipe_seq", allocationSize = 1, initialValue = 1)
    private Integer id;

    @Column(name = "recipe_title")
    private String title;


    @Column(name = "recipe_desc")
    private String desc;


    @Column(name = "recipe_instruction")
    private String instruction;

}
