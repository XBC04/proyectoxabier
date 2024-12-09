package com.example.proyectoxabier.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
}
