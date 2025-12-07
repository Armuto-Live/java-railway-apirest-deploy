package com.apirest.apirest.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nombre;

    @Column(name = "precio_soles")
    private float precioSoles;

    @Column(name = "precio_dolar")
    private float precioDolar;

    private String descripcion;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @CreatedDate
    @Column(name = "inserted_at",  nullable = false, updatable = false,
            columnDefinition = "TIMESTAMP(0)")
    private LocalDateTime insertedAt;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @LastModifiedDate
    @Column(name = "updated_at", nullable = false,
            columnDefinition = "TIMESTAMP(0)")
    private LocalDateTime updatedAt;

    @ManyToOne
    @JoinColumn(name = "categoria_id", nullable = false)
    private CategoriaEntity categoriaId;

    public long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getPrecioDolar() {
        return precioDolar;
    }

    public void setPrecioDolar(float precioDolar) {
        this.precioDolar = precioDolar;
    }

    public float getPrecioSoles() {
        return precioSoles;
    }

    public void setPrecioSoles(float precioSoles) {
        this.precioSoles = precioSoles;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public CategoriaEntity getCategoria() { return categoriaId; }

    public void setCategoria(CategoriaEntity categoria) { this.categoriaId = categoria; }
}
