package xyz.backend.proyecto.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Service;
import xyz.backend.proyecto.modelo.Pais;
import xyz.backend.proyecto.repository.PaisRepository;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Service
public class PaisService {
    @Autowired
    private PaisRepository paisRepository;


    public List<Pais> findAll() {
        return paisRepository.findAll();
    }

}
