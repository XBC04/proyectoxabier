package com.example.proyectoxabier.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.proyectoxabier.models.Alfombra;
import com.example.proyectoxabier.services.AlfombraService;

@Controller
public class AlfombraController {

    @Autowired
    private AlfombraService alfombraService;

    @GetMapping("/alfombras")
    public String listarAlfombras(Model model) {
        List<Alfombra> alfombras = alfombraService.obtenerTodas();
        model.addAttribute("alfombras", alfombras);
        return "alfombras";
    }
}
