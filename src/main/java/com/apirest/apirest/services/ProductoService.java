package com.apirest.apirest.services;

import com.apirest.apirest.entities.Producto;
import com.apirest.apirest.repositories.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;


@Service
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    public Producto crearProducto(Producto producto){
        return productoRepository.save(producto);
    }

    public List<Producto> obtenerProductos(){
        return productoRepository.findAll();
    }

    public Producto obtenerProductoId(Long id){
        return productoRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("No se encontró el producto con el id: " + id));
    }

    public Producto actualizarProducto(Long id, Producto detalleProducto){
        Producto producto = productoRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("No se encontró el producto con el id: " + id));

        producto.setNombre(detalleProducto.getNombre());
        producto.setPrecioDolar(detalleProducto.getPrecioDolar());
        producto.setPrecioSoles(detalleProducto.getPrecioSoles());
        producto.setDescripcion(detalleProducto.getDescripcion());

        return productoRepository.save(producto);
    }

    public String eliminarProducto(Long id){
        Producto producto = productoRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("No se encontró el producto con el id: " + id));

        productoRepository.delete(producto);
        return "El producto fue eliminado";
    }
}
