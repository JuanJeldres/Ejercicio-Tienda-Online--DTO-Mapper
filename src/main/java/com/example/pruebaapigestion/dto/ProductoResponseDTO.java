package com.example.pruebaapigestion.dto;

import lombok.Builder;

@Builder
public record ProductoResponseDTO(Long id, String nombreProducto, int stock) {
}
