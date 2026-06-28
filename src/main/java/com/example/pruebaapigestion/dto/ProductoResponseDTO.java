package com.example.pruebaapigestion.dto;

import lombok.Builder;

@Builder
public record ProductoResponseDTO(Long id, String nombre, int stock) {
}
