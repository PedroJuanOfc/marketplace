package com.omnisell.marketplace.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data //Também do Lombok para criar os Getters e Setters
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(unique = true)
    private String email;

    private String password;

    private String role;
}