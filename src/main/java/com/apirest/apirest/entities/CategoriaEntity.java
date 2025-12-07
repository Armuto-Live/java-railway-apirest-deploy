package com.apirest.apirest.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@Table(name = "categoria")
@EntityListeners(AuditingEntityListener.class)
public class CategoriaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nombre;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "inserted_at", nullable = false, updatable = false,
            columnDefinition = "TIMESTAMP(0)")
    @CreatedDate
    private LocalDateTime insertedAt;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "updated_at", nullable = false,
            columnDefinition = "TIMESTAMP(0)")
    @LastModifiedDate
    private LocalDateTime updatedAt;

    public long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
