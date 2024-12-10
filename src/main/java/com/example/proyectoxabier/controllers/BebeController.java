package com.example.proyectoxabier.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.proyectoxabier.models.Bebe;
import com.example.proyectoxabier.services.BebeService;

@Controller
public class BebeController {

    @Autowired
    private BebeService bebeService;

    @GetMapping("/bebes")
    public String listarBebes(Model model) {
        List<Bebe> bebes = bebeService.obtenerTodos();
        model.addAttribute("bebes", bebes);
        return "bebes";
    }

    @GetMapping("/bebes/crear")
    public String mostrarFormularioCrear(Model model) {
        model.addAttribute("bebe", new Bebe());
        return "crearBebes";
    }

    @PostMapping("/bebes/crear")
    public String crearBebe(@ModelAttribute Bebe bebe) {
        bebeService.guardarBebe(bebe);
        return "redirect:/bebes";
    }
}