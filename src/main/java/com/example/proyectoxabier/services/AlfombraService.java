package com.example.proyectoxabier.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.proyectoxabier.models.Alfombra;
import com.example.proyectoxabier.repositories.AlfombraRepository;

@Service
public class AlfombraService {

    @Autowired
    private AlfombraRepository alfombraRepository;

    public List<Alfombra> obtenerTodas() {
        return alfombraRepository.findAll();
    }

    public Alfombra guardarAlfombra(Alfombra alfombra) {
        return alfombraRepository.save(alfombra);
    }
}