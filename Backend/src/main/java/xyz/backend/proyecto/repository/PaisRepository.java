package xyz.backend.proyecto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import xyz.backend.proyecto.modelo.Pais;

public interface PaisRepository extends JpaRepository<Pais,Long> {
}
