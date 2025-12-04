package com.apirest.apirest.repositories;


import com.apirest.apirest.entities.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Long> {



}
