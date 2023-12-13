package xyz.backend.proyecto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import xyz.backend.proyecto.modelo.Ciudad;

public interface CiudadRepository extends JpaRepository<Ciudad,Long> {
}
