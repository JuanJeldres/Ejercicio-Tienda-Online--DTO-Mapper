package com.example.pruebaapigestion.service;

import com.example.pruebaapigestion.dto.ClienteRequestDTO;
import com.example.pruebaapigestion.dto.ClienteResponseDTO;
import com.example.pruebaapigestion.dto.ProductoRequestDTO;
import com.example.pruebaapigestion.dto.ProductoResponseDTO;

import java.util.List;

public interface ProductoService {
    ProductoResponseDTO crearProducto(ProductoRequestDTO request);
    List<ProductoResponseDTO> obtenerProductos();
    ProductoResponseDTO productoByID(Long id);

    ProductoResponseDTO actualizarProducto(Long id, ProductoRequestDTO dto);
    ProductoResponseDTO eliminarProducto(Long id);
}