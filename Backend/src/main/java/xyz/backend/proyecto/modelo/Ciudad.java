package xyz.backend.proyecto.modelo;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table (name = "ciudad")
@Data
public class Ciudad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  long id;
    private  String nombre;
    @ManyToOne
    @JoinColumn(name="id_pais")
    private Pais pais ;
}
