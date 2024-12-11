package com.example.proyectoxabier.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.proyectoxabier.models.Almohada;
import com.example.proyectoxabier.repositories.AlmohadaRepository;

@Service
public class AlmohadaService {

    @Autowired
    private AlmohadaRepository almohadaRepository;

    public List<Almohada> obtenerTodas() {
        return almohadaRepository.findAll();
    }

    public Almohada guardarAlmohada(Almohada almohada) {
        return almohadaRepository.save(almohada);
    }

    public Optional<Almohada> obtenerPorId(Long id) {
        return almohadaRepository.findById(id);
    }
}
