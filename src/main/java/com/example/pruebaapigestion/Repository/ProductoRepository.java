package com.example.pruebaapigestion.Repository;

import com.example.pruebaapigestion.Model.ModelProducto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends JpaRepository<ModelProducto, Long> {
}
