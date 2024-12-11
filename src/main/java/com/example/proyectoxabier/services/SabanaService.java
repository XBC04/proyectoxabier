package com.example.proyectoxabier.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.proyectoxabier.models.Sabana;
import com.example.proyectoxabier.repositories.SabanaRepository;

@Service
public class SabanaService {
    @Autowired
    private SabanaRepository sabanaRepository;

    public List<Sabana> obtenerTodas() {
        return sabanaRepository.findAll();
    }

    public Sabana guardarSabana(Sabana sabana) {
        return sabanaRepository.save(sabana);
    }

    public Optional<Sabana> obtenerPorId(Long id) {
        return sabanaRepository.findById(id);
    }
}
