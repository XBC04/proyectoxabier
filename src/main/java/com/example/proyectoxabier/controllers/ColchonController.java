package com.example.proyectoxabier.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.proyectoxabier.models.Colchon;
import com.example.proyectoxabier.services.ColchonService;

@Controller
public class ColchonController {

    @Autowired
    private ColchonService colchonService;

    @GetMapping("/colchones")
    public String listarColchones(Model model) {
        List<Colchon> colchones = colchonService.obtenerTodos();
        model.addAttribute("colchones", colchones);
        return "colchones";
    }

    @GetMapping("/colchones/crear")
    public String mostrarFormularioCrear(Model model) {
        model.addAttribute("colchon", new Colchon());
        return "crearColchones";
    }

    @PostMapping("/colchones/crear")
    public String crearColchon(@ModelAttribute Colchon colchon) {
        colchonService.guardarColchon(colchon);
        return "redirect:/colchones";
    }
}