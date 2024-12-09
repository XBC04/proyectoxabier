package com.example.proyectoxabier.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.proyectoxabier.models.Ofertas;
import com.example.proyectoxabier.services.OfertasService;

@Controller
public class HomeController {
    @Autowired
    private OfertasService ofertaService;

    @GetMapping("/")
    public String home(Model model) {
        List<Ofertas> ofertas = ofertaService.obtenerTodas();
        model.addAttribute("ofertas", ofertas);
        return "home";
    }
}
