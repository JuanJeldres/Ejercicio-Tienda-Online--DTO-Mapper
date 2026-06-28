package com.example.pruebaapigestion.mapper;

import com.example.pruebaapigestion.Model.ModelProducto;
import com.example.pruebaapigestion.dto.ProductoRequestDTO;
import com.example.pruebaapigestion.dto.ProductoResponseDTO;
import lombok.Builder;
import org.springframework.stereotype.Component;

//@Builder
@Component
public class ProductoMapper {
    public ModelProducto toModel (ProductoRequestDTO request){
        ModelProducto producto = new ModelProducto();
        producto.setNombreProducto(request.nombreProducto());
        producto.setDescripcion(request.descripcion());
        producto.setPrecio(request.precio());
        producto.setStock(request.stock());
        producto.setCategoria(request.categoria());
        return producto;
    }

    public ProductoResponseDTO toDto (ModelProducto producto){
        return ProductoResponseDTO.builder()
                .id(producto.getId())
                .nombreProducto(producto.getNombreProducto())
                .stock(producto.getStock())
                .build();
    }
}

