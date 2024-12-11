package com.example.proyectoxabier.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.proyectoxabier.models.Colchon;
import com.example.proyectoxabier.repositories.ColchonRepository;

@Service
public class ColchonService {

    @Autowired
    private ColchonRepository colchonRepository;

    public List<Colchon> obtenerTodos() {
        return colchonRepository.findAll();
    }

    public Colchon guardarColchon(Colchon colchon) {
        return colchonRepository.save(colchon);
    }

    public Optional<Colchon> obtenerPorId(Long id) {
        return colchonRepository.findById(id);
    }
}
