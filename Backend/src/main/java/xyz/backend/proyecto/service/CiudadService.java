package xyz.backend.proyecto.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Service;
import xyz.backend.proyecto.modelo.Ciudad;
import xyz.backend.proyecto.repository.CiudadRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Service
public class CiudadService  {
    @Autowired
    private  CiudadRepository ciudadRepository;

    public List<Ciudad> findAllByPais(Long id){ //usar siempre long
        List<Ciudad> ciudadRespuesta= new ArrayList<>();
        List<Ciudad> ciudad= ciudadRepository.findAll(); // Se obtiene todos los paises
        for(int i=0 ; i<ciudad.size();i++){
            if(ciudad.get(i).getPais().getId()==id){
                ciudadRespuesta.add((ciudad.get(i)));
            }
        }
        return  ciudadRespuesta;
    }
}
