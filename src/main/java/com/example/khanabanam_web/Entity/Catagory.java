package com.example.khanabanam_web.Entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter

@Entity
@Table (name = "Catagory")
public class Catagory {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "catagory_seq_gen")
    @SequenceGenerator(name = "catagory_seq_gen", sequenceName = "catagory_seq", allocationSize = 1, initialValue = 1)
    private Integer id;



    @Column(name = "Catagory_name")
    private String catagoryName;

//    @Column(name = "")

}

