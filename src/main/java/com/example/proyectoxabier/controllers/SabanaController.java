package com.example.proyectoxabier.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.proyectoxabier.models.Sabana;
import com.example.proyectoxabier.services.SabanaService;

@Controller
public class SabanaController {
    @Autowired
    private SabanaService sabanaService;

    @GetMapping("/sabanas")
    public String mostrarSabanas(Model model) {
        List<Sabana> sabanas = sabanaService.obtenerTodas();
        model.addAttribute("sabanas", sabanas);
        return "sabanas";
    }

    @GetMapping("/sabanas/crear")
    public String mostrarFormularioCrear(Model model) {
        model.addAttribute("sabana", new Sabana());
        return "crearSabanas";
    }

    @PostMapping("/sabanas/crear")
    public String crearSabana(@ModelAttribute Sabana sabana) {
        sabanaService.guardarSabana(sabana);
        return "redirect:/sabanas";
    }
}
