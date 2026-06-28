package com.example.pruebaapigestion.controller;

import com.example.pruebaapigestion.dto.ClienteRequestDTO;
import com.example.pruebaapigestion.dto.ClienteResponseDTO;
import com.example.pruebaapigestion.service.ClienteService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/clientes")
public class ClienteController {
    private final ClienteService service;

    @PostMapping
    public ClienteResponseDTO crearCliente(@RequestBody ClienteRequestDTO request) {
        return service.crearCliente(request);
    }

    @GetMapping
    public List<ClienteResponseDTO> obtenerClientes() {
        return service.obtenerClientes();
    }

    @GetMapping("/{id}")
    public ClienteResponseDTO clienteById(@PathVariable Long id) {
        return service.clienteByID(id);
    }

    @PutMapping("/{id}")
    public ClienteResponseDTO actualizarCliente(@PathVariable Long id, @RequestBody ClienteRequestDTO request){
        return service.actualizarCliente(id,request);
    }

    @DeleteMapping("/{id}")
    public ClienteResponseDTO eliminarCliente(@PathVariable Long id){
        return service.eliminarCliente(id);
    }
}