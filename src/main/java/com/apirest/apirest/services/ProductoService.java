package com.apirest.apirest.services;

import com.apirest.apirest.dto.ProductoDTO;
import com.apirest.apirest.entities.CategoriaEntity;
import com.apirest.apirest.entities.Producto;
import com.apirest.apirest.repositories.CategoriaRepository;
import com.apirest.apirest.repositories.ProductoRepository;
import jakarta.persistence.EntityNotFoundException;
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

    @Autowired
    private CategoriaRepository categoriaRepository;

    public Producto crearProducto(ProductoDTO productoDTO){
        CategoriaEntity categoria = categoriaRepository.findById(productoDTO.getCategoriaId())
                .orElseThrow(() -> new RuntimeException("No existe la categoría con id: " + productoDTO.getCategoriaId()));

        Producto producto = new Producto();
        producto.setNombre(productoDTO.getNombre());
        producto.setPrecioSoles(productoDTO.getPrecioSoles());
        producto.setPrecioDolar(productoDTO.getPrecioDolar());
        producto.setDescripcion(productoDTO.getDescripcion());
        producto.setCategoria(categoria);

        return productoRepository.save(producto);
    }

    public List<Producto> obtenerProductos(){
        return productoRepository.findAll();
    }

    public ProductoDTO obtenerProductoId(Long id){
        final Optional<Producto> productoEncontrado = productoRepository.findById(id);
        if (productoEncontrado.isEmpty()){
            throw new EntityNotFoundException("Usuario con id " + id + " no encontrado");
        }

        final Producto productoDB = productoEncontrado.get();
        return new ProductoDTO(productoDB.getNombre(), productoDB.getPrecioSoles(), productoDB.getPrecioDolar(), productoDB.getDescripcion(), productoDB.getCategoria().getId());

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
