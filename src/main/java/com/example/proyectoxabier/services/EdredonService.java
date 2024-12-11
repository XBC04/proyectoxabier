package com.example.proyectoxabier.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.proyectoxabier.models.Edredon;
import com.example.proyectoxabier.repositories.EdredonRepository;

@Service
public class EdredonService {
    @Autowired
    private EdredonRepository edredonRepository;

    public List<Edredon> obtenerTodos() {
        return edredonRepository.findAll();
    }

    public Edredon guardarEdredon(Edredon edredon) {
        return edredonRepository.save(edredon);
    }

    public Optional<Edredon> obtenerPorId(Long id) {
        return edredonRepository.findById(id);
    }
}
