package com.example.proyectoxabier.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.proyectoxabier.exceptions.ComprarAccessException;

@Controller
public class ComprarController {

    @GetMapping("/comprar")
    public String manejarComprar() {
        throw new ComprarAccessException("No se puede acceder al área de compras, se añadirá en futuras actualizaciones.");
    }
}