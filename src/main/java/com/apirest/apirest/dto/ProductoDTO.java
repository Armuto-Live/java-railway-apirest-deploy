package com.apirest.apirest.dto;

import com.apirest.apirest.entities.CategoriaEntity;

import java.io.Serializable;

public class ProductoDTO implements Serializable {
    final String nombre;
    final float precioSoles;
    final float precioDolar;
    final String descripcion;
    final CategoriaEntity categoriaId;

    public ProductoDTO(String nombre, float precioSoles, float precioDolar, String descripcion, CategoriaEntity categoriaId) {
        this.nombre = nombre;
        this.precioSoles = precioSoles;
        this.precioDolar = precioDolar;
        this.descripcion = descripcion;
        this.categoriaId = categoriaId;
    }

    public String getNombre() {
        return nombre;
    }

    public float getPrecioSoles() {
        return precioSoles;
    }

    public float getPrecioDolar() {
        return precioDolar;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public CategoriaEntity getCategoriaId() {
        return categoriaId;
    }
}
