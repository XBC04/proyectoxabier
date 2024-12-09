package com.example.proyectoxabier.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PoliticaPrivacidadController {

    @GetMapping("/privacidad")
    public String mostrarPoliticaPrivacidad() {
        return "privacidad"; 
    }
}