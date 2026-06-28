package com.example.pruebaapigestion.service;

import com.example.pruebaapigestion.dto.ClienteRequestDTO;
import com.example.pruebaapigestion.dto.ClienteResponseDTO;

import java.util.List;

public interface ClienteService {
    ClienteResponseDTO crearCliente(ClienteRequestDTO request);
    List<ClienteResponseDTO> obtenerClientes();
    ClienteResponseDTO clienteByID(Long id);

    ClienteResponseDTO actualizarCliente(Long id, ClienteRequestDTO dto);
    ClienteResponseDTO eliminarCliente(Long id);

    /*List<ClienteResponseDTO> findByDireccion(String direccion);*/
}
