package com.example.pruebaapigestion.service;

import com.example.pruebaapigestion.Model.ModelProducto;
import com.example.pruebaapigestion.Repository.ProductoRepository;
import com.example.pruebaapigestion.dto.ProductoRequestDTO;
import com.example.pruebaapigestion.dto.ProductoResponseDTO;
import com.example.pruebaapigestion.mapper.ProductoMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class ProductoServiceImpl implements ProductoService{
private final ProductoRepository repository;
private final ProductoMapper mapper;

    @Override
    public ProductoResponseDTO crearProducto(ProductoRequestDTO request){
        ModelProducto producto = mapper.toModel(request);
        repository.save(producto);
        return mapper.toDto(producto);
    }

    @Override
    public List<ProductoResponseDTO> obtenerProductos(){
        return repository.findAll()
                .stream()
                .map(mapper::toDto)
                .toList();
    }

    @Override
    public ProductoResponseDTO productoByID(Long id){
        ModelProducto producto = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));
        return mapper.toDto(producto);
    }

    @Override
    public ProductoResponseDTO actualizarProducto(Long id, ProductoRequestDTO dto){
        ModelProducto producto = repository.findById(id).orElseThrow(() -> new RuntimeException("Producto no encontrado"));
        producto.setNombreProducto(dto.nombreProducto()); //dto o request?
        producto.setDescripcion(dto.descripcion());
        producto.setPrecio(dto.precio());
        producto.setStock(dto.stock());
        producto.setCategoria(dto.categoria());
        ModelProducto actualizado = repository.save(producto);
        return mapper.toDto(actualizado);
    }

    @Override
    public ProductoResponseDTO eliminarProducto(Long id){
        ModelProducto producto = repository.findById(id)
                .orElseThrow(()-> new RuntimeException("No encontrado"));
        repository.delete(producto);
        return mapper.toDto(producto);
    }

}
