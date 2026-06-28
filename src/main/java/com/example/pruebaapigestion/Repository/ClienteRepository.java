package com.example.pruebaapigestion.Repository;

import com.example.pruebaapigestion.Model.ModelUsuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteRepository extends JpaRepository<ModelUsuario, Long> {
    /*List<ModelUsuario> findByDireccion(String direccion);*/ //para buscar por direccion

    /*@Query("SELECT c FROM ModelUsuario c WHERE c.nombre = :nombre")
    List<ModelUsuario> buscarPorDireccion(@Param("nombre") String nombre);*/
}
