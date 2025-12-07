package com.apirest.apirest.controllers;

import com.apirest.apirest.entities.CategoriaEntity;
import com.apirest.apirest.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @PostMapping
    public CategoriaEntity crearCategoria(@RequestBody CategoriaEntity categoriaEntity){
        return categoriaRepository.save(categoriaEntity);
    }

    @GetMapping
    public List<CategoriaEntity> listarCategorias(){
        return categoriaRepository.findAll();
    }


}
