package com.example.pruebaapigestion.controller;

import com.example.pruebaapigestion.dto.ProductoRequestDTO;
import com.example.pruebaapigestion.dto.ProductoResponseDTO;
import com.example.pruebaapigestion.service.ProductoService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/productos")
public class ProductoController {
    private final ProductoService service;

    @PostMapping
    public ProductoResponseDTO crearProducto(@RequestBody ProductoRequestDTO request){
        return  service.crearProducto(request);
    }

    @GetMapping
    public List<ProductoResponseDTO> obtenerProductos(){
        return service.obtenerProductos();
    }

    @GetMapping("/{id}")
    public ProductoResponseDTO productoByID(@PathVariable Long id){
        return service.productoByID(id);
    }

    @PutMapping("/{id}")
    public ProductoResponseDTO actualizarProducto(@PathVariable Long id, @RequestBody ProductoRequestDTO request){
        return service.actualizarProducto(id, request);
    }

    @DeleteMapping("/{id}")
    public ProductoResponseDTO eliminarProducto(@PathVariable Long id){
        return service.eliminarProducto(id);
    }
}
