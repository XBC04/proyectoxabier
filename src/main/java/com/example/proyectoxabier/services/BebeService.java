package com.example.proyectoxabier.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.proyectoxabier.models.Bebe;
import com.example.proyectoxabier.repositories.BebeRepository;

@Service
public class BebeService {

    @Autowired
    private BebeRepository bebeRepository;

    public List<Bebe> obtenerTodos() {
        return bebeRepository.findAll();
    }

    public Bebe guardarBebe(Bebe bebe) {
        return bebeRepository.save(bebe);
    }
}
