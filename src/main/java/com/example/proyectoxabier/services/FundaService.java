package com.example.proyectoxabier.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.proyectoxabier.models.Funda;
import com.example.proyectoxabier.repositories.FundaRepository;

@Service
public class FundaService {

    @Autowired
    private FundaRepository fundaRepository;

    public List<Funda> obtenerTodas() {
        return fundaRepository.findAll();
    }

    public Funda guardarFunda(Funda funda) {
        return fundaRepository.save(funda);
    }
}
