package xyz.backend.proyecto.modelo;

import jakarta.persistence.*;
import lombok.Data;



@Entity
@Data
@Table(name = "persona")
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  long id;
    private String nombre;
    private String apellido;
    private  int edad;

    @ManyToOne
    @JoinColumn(name = "id_pais")
    private Pais pais;

    @ManyToOne
    @JoinColumn(name = "ciudad_id")
    private  Ciudad ciudad;

}
