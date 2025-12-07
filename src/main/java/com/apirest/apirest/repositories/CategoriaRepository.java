package com.apirest.apirest.repositories;

import com.apirest.apirest.entities.CategoriaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<CategoriaEntity, Long> {
}
