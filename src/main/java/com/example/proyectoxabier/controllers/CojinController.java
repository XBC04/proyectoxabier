package com.example.proyectoxabier.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.proyectoxabier.models.Cojin;
import com.example.proyectoxabier.services.CojinService;

@Controller
public class CojinController {

    @Autowired
    private CojinService cojinService;

    @GetMapping("/cojines")
    public String listarCojines(Model model) {
        List<Cojin> cojines = cojinService.obtenerTodos();
        model.addAttribute("cojines", cojines);
        return "cojines";
    }

    @GetMapping("/cojines/crear")
    public String mostrarFormularioCrear(Model model) {
        model.addAttribute("cojin", new Cojin());
        return "crearCojines";
    }

    @PostMapping("/cojines/crear")
    public String crearCojin(@ModelAttribute Cojin cojin) {
        cojinService.guardarCojin(cojin);
        return "redirect:/cojines";
    }
}