package xyz.backend.proyecto.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import xyz.backend.proyecto.modelo.Persona;
import xyz.backend.proyecto.repository.PersonaRepository;

import java.util.List;
import java.util.Optional;


@Service
public class PersonaService {
    @Autowired
    private PersonaRepository personaRepository;

    public Optional<Persona> getById(Long aLong) {
        return personaRepository.findById(aLong);
    }
    public List<Persona> findAll() {
        return personaRepository.findAll();
    }
    public <S extends Persona> S save(S entity) {
        return personaRepository.save(entity);
    }
    public void deleteById(Long id) {
        personaRepository.deleteById(id);
    }
    public void delete(Persona entity) {
        personaRepository.delete(entity);
    }

}
