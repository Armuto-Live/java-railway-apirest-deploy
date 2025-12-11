package com.apirest.apirest.controllers;
import com.apirest.apirest.entities.Producto;
import com.apirest.apirest.repositories.ProductoRepository;
import com.apirest.apirest.services.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    @Autowired
    private final ProductoService productoService;

    public ProductoController(ProductoService productoService){
        this.productoService = productoService;
    }

    @GetMapping
    public List<Producto> obtenerProductos(){
        return productoService.obtenerProductos();
    }

    @GetMapping("/{id}")
    public Producto obtenerProductoId(@PathVariable Long id){
        return productoService.obtenerProductoId(id);
    }

    @PostMapping
    public Producto crearProducto(@RequestBody Producto producto){
        return productoService.crearProducto(producto);
    }

    @PutMapping("/{id}")
    public Producto actualizarProducto(@PathVariable Long id, @RequestBody Producto detalleProducto){
        return productoService.actualizarProducto(id, detalleProducto);
    }

    @DeleteMapping("/{id}")
    public String eliminarProducto(@PathVariable Long id){
        return productoService.eliminarProducto(id);
    }
}
