package com.example.proyectoxabier.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.proyectoxabier.models.Pijama;
import com.example.proyectoxabier.repositories.PijamaRepository;

@Service
public class PijamaService {

    @Autowired
    private PijamaRepository pijamaRepository;

    public List<Pijama> obtenerTodos() {
        return pijamaRepository.findAll();
    }

    public Pijama guardarPijama(Pijama pijama) {
        return pijamaRepository.save(pijama);
    }

    public Optional<Pijama> obtenerPorId(Long id) {
        return pijamaRepository.findById(id);
    }
}
