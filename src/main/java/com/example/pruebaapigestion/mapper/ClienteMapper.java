package com.example.pruebaapigestion.mapper;

import com.example.pruebaapigestion.Model.ModelUsuario;
import com.example.pruebaapigestion.dto.ClienteRequestDTO;
import com.example.pruebaapigestion.dto.ClienteResponseDTO;
import lombok.Builder;
import org.springframework.stereotype.Component;

//@Builder
@Component
public class ClienteMapper {
    public ModelUsuario toModel (ClienteRequestDTO request){
        ModelUsuario cliente = new ModelUsuario();
        cliente.setNombre(request.nombre());
        cliente.setApellido(request.apellido());
        cliente.setCorreo(request.correo());
        cliente.setTelefono(request.telefono());
        cliente.setDireccion(request.direccion());
        return cliente;
    }

    public ClienteResponseDTO toDto (ModelUsuario cliente){
        return ClienteResponseDTO.builder()
                .id(cliente.getId())
                .nombre(cliente.getNombre())
                .correo(cliente.getCorreo())
                .build();
    }

}
