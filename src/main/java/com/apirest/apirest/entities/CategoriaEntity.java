package com.apirest.apirest.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "categoria")
public class CategoriaEntity {
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long nombre;
}
