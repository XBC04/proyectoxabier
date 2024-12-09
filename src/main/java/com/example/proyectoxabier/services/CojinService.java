package com.example.proyectoxabier.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.proyectoxabier.models.Cojin;
import com.example.proyectoxabier.repositories.CojinRepository;

@Service
public class CojinService {

    @Autowired
    private CojinRepository cojinRepository;

    public List<Cojin> obtenerTodos() {
        return cojinRepository.findAll();
    }

    public Cojin guardarCojin(Cojin cojin) {
        return cojinRepository.save(cojin);
    }
}