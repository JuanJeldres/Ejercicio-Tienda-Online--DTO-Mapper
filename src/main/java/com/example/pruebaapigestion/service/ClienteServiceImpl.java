package com.example.pruebaapigestion.service;

import com.example.pruebaapigestion.Model.ModelUsuario;
import com.example.pruebaapigestion.Repository.ClienteRepository;
import com.example.pruebaapigestion.dto.ClienteRequestDTO;
import com.example.pruebaapigestion.dto.ClienteResponseDTO;
import com.example.pruebaapigestion.mapper.ClienteMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class ClienteServiceImpl implements ClienteService {
    private final ClienteRepository repository;
    private final ClienteMapper mapper;

    @Override
    public ClienteResponseDTO crearCliente(ClienteRequestDTO request){
        ModelUsuario cliente = mapper.toModel(request);
        repository.save(cliente); //en sql .save es insert into de sql
        return mapper.toDto(cliente);
    }

    @Override
    public List<ClienteResponseDTO> obtenerClientes() {
        return repository.findAll() //find all es select * from de sql
                .stream()
                .map(mapper::toDto)// es lo mismo que cliente -> mapper.toDto(cliente)
                .toList();
    }

    @Override
    public ClienteResponseDTO clienteByID(Long id){
        ModelUsuario cliente = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("cliente no encontrado"));
        return mapper.toDto(cliente);
    }

    @Override
    public ClienteResponseDTO actualizarCliente(Long id, ClienteRequestDTO request){
        ModelUsuario cliente = repository.findById(id).orElseThrow(() -> new RuntimeException("Cliente no encontrado"));
        cliente.setNombre(request.nombre());
        cliente.setDireccion(request.direccion());
        cliente.setTelefono(request.telefono());
        cliente.setCorreo(request.correo());
        cliente.setApellido(request.apellido());
        ModelUsuario actualizado = repository.save(cliente);
        return mapper.toDto(actualizado);
    }

    @Override
    public ClienteResponseDTO eliminarCliente(Long id){
        ModelUsuario cliente = repository.findById(id)
                .orElseThrow(()-> new RuntimeException("No encontrado"));
        repository.delete(cliente);
        return mapper.toDto(cliente);
    }

}

 /*public ModelUsuario guardar(ModelUsuario usuario) {
        return repository.save(usuario);
    }
    public ModelUsuario buscarPorId(Long id) {
        return repository.findById(id).orElse(null);
    }

    public void eliminar(Long id) {
        repository.deleteById(id);
    }*/
