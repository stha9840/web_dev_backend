package com.example.khanabanam_web.Entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "Ingrediant")
public class ingrediant {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "ingrediant_seq_gen")
    @SequenceGenerator(name = "ingrediant_seq_gen", sequenceName = "ingrediant_seq", allocationSize = 1, initialValue = 1)
    private Integer id;


    @Column(name = "Ingrediant_name")
    private String ingrediantName;


    @Column(name = "Ingrediant_quantity")
    private Integer ingrediantQuantity;

    @Column(name = "recipe_instruction")
    private String instruction;



}
