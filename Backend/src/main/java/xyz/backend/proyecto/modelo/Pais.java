package xyz.backend.proyecto.modelo;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "pais")
@Data
public class Pais {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nombre;

}
