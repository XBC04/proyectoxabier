package com.example.proyectoxabier.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TerminosController {

    @GetMapping("/terminos")
    public String mostrarTerminos() {
        return "terminos"; 
    }
}
