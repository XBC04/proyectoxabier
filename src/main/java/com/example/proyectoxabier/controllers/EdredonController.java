package com.example.proyectoxabier.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.proyectoxabier.models.Edredon;
import com.example.proyectoxabier.services.EdredonService;

@Controller
public class EdredonController {
    @Autowired
        private EdredonService edredonService;

        @GetMapping("/edredones")
        public String home(Model model) {
            List<Edredon> edredones = edredonService.obtenerTodos();
            model.addAttribute("edredones", edredones);
            return "edredones";
    }

    // Mostrar formulario para agregar un nuevo edredón
    @GetMapping("/edredones/crear")
    public String mostrarFormularioCrear(Model model) {
        model.addAttribute("edredon", new Edredon());
        return "crearEdredon";
    }

    // Manejar la creación de un nuevo edredón
    @PostMapping("/edredones/crear")
    public String crearEdredon(@ModelAttribute Edredon edredon) {
        edredonService.guardarEdredon(edredon);
        return "redirect:/edredones";
    }
}
