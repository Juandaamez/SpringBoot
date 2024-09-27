package com.example.backend_spring.service;

import com.example.backend_spring.exception.ProductoNoEncontradoException;
import com.example.backend_spring.model.Producto;
import com.example.backend_spring.repository.ProductoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepositorio productoRepositorio;

    public List<Producto> obtenerTodosLosProductos() {
        return productoRepositorio.findAll();
    }

    public Producto crearProducto(Producto producto) {
        return productoRepositorio.save(producto);
    }

    public Producto obtenerProductoPorId(Long id) {
        return productoRepositorio.findById(id)
                .orElseThrow(() -> new ProductoNoEncontradoException("Producto no encontrado con ID: " + id));
    }

    public Producto actualizarProducto(Long id, Producto detallesProducto) {
        Producto producto = obtenerProductoPorId(id);
        producto.setNombre(detallesProducto.getNombre());
        producto.setPrecio(detallesProducto.getPrecio());
        return productoRepositorio.save(producto);
    }

    public void eliminarProducto(Long id) {
        Producto producto = obtenerProductoPorId(id);
        productoRepositorio.delete(producto);
    }
}
