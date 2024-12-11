package com.example.proyectoxabier.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.proyectoxabier.models.Ofertas;
import com.example.proyectoxabier.repositories.OfertasRepository;

@Service
public class OfertasService {
    @Autowired
    private OfertasRepository ofertasRepository;

    public List<Ofertas> obtenerTodas() {
        return ofertasRepository.findAll();
    }

    public Ofertas guardarOferta(Ofertas oferta) {
        return ofertasRepository.save(oferta);
    }
}