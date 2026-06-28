package com.example.pruebaapigestion.mapper;

import com.example.pruebaapigestion.Model.ModelProducto;
import com.example.pruebaapigestion.Model.ModelUsuario;
import com.example.pruebaapigestion.dto.ClienteRequestDTO;
import com.example.pruebaapigestion.dto.ClienteResponseDTO;
import com.example.pruebaapigestion.dto.ProductoRequestDTO;
import lombok.Builder;
import org.springframework.stereotype.Component;

@Builder
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

    public ClienteResponseDTO toDto (ModelUsuario cliente){
        return ClienteResponseDTO.builder()
                .id(cliente.getId())
                .nombre(cliente.getNombre())
                .correo(cliente.getCorreo())
                .build();
    }
}

