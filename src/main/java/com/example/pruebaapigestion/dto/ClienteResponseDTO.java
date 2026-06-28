package com.example.pruebaapigestion.dto;

import lombok.Builder;

@Builder //este 'construye' objetos sin usar constructor
public record ClienteResponseDTO(Long id, String nombre, String correo) {
}
