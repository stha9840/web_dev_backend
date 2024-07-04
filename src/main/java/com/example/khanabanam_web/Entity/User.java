package com.example.khanabanam_web.Entity;


import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name= "tbl_user")
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "user_seq_gen")
    @SequenceGenerator(name = "user_seq_gen", sequenceName = "user_seq", allocationSize = 1, initialValue = 1)
    private Integer id;

    @Column(name = "user_name")
    private String userName;


    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

}
