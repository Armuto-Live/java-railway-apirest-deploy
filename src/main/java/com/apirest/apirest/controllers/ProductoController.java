package com.apirest.apirest.controllers;
import com.apirest.apirest.entities.Producto;
import com.apirest.apirest.repositories.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    @Autowired
    private ProductoRepository productoRepository;

    @GetMapping
    public List<Producto> obtenerProductos(){
        return productoRepository.findAll();
    }

    @GetMapping("/{id}")
    public Producto obtenerProductoId(@PathVariable Long id){
        return productoRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("No se encontró el producto con el id: " + id));
    }

    @PostMapping
    public Producto crearProducto(@RequestBody Producto producto){
        return productoRepository.save(producto);

    }

    @PutMapping("/{id}")
    public Producto actualizarProducto(@PathVariable Long id, @RequestBody Producto detalleProducto){
        Producto producto = productoRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("No se encontró el producto con el id: " + id));

        producto.setNombre(detalleProducto.getNombre());
        producto.setPrecio(detalleProducto.getPrecio());

        return productoRepository.save(producto);
    }

    @DeleteMapping("/{id}")
    public String eliminarProducto(@PathVariable Long id){
        Producto producto = productoRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("No se encontró el producto con el id: " + id));

        productoRepository.delete(producto);
        return "El producto fue eliminado";
    }
}
