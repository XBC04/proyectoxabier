package com.example.proyectoxabier.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.proyectoxabier.models.Funda;
import com.example.proyectoxabier.services.FundaService;

@Controller
public class FundaController {

    @Autowired
    private FundaService fundaService;

    @GetMapping("/fundas")
    public String listarFundas(Model model) {
        List<Funda> fundas = fundaService.obtenerTodas();
        model.addAttribute("fundas", fundas);
        return "fundas";
    }

    @GetMapping("/fundas/crear")
    public String mostrarFormularioCrear(Model model) {
        model.addAttribute("funda", new Funda());
        return "crearFundas";
    }

    @PostMapping("/fundas/crear")
    public String crearFunda(@ModelAttribute Funda funda) {
        fundaService.guardarFunda(funda);
        return "redirect:/fundas";
    }
}
