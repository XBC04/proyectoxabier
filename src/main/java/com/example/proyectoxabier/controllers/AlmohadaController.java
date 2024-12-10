package com.example.proyectoxabier.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.proyectoxabier.models.Almohada;
import com.example.proyectoxabier.services.AlmohadaService;

@Controller
public class AlmohadaController {

    @Autowired
    private AlmohadaService almohadaService;

    @GetMapping("/almohadas")
    public String listarAlmohadas(Model model) {
        List<Almohada> almohadas = almohadaService.obtenerTodas();
        model.addAttribute("almohadas", almohadas);
        return "almohadas";
    }

    @GetMapping("/almohadas/crear")
    public String mostrarFormularioCrear(Model model) {
        model.addAttribute("almohada", new Almohada());
        return "crearAlmohadas";
    }

    @PostMapping("/almohadas/crear")
    public String crearAlmohada(@ModelAttribute Almohada almohada) {
        almohadaService.guardarAlmohada(almohada);
        return "redirect:/almohadas";
    }
}
