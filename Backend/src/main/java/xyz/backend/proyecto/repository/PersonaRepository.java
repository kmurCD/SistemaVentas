package xyz.backend.proyecto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import xyz.backend.proyecto.modelo.Persona;

public interface PersonaRepository extends JpaRepository<Persona,Long> {
}
