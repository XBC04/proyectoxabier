package com.example.proyectoxabier.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AyudaController {
    @GetMapping("/ayuda")
    public String mostrarAyuda() {
        return "ayuda";
    }
}
