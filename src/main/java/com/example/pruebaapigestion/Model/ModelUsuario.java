package com.example.pruebaapigestion.Model;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Table(name = "clientes")
@Getter
@Setter
@NoArgsConstructor
public class ModelUsuario {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String nombre;
        private String apellido;
        private String correo;
        private int telefono;
        private String direccion;

        // getters y setters (ya hechos por lombok)
    }
