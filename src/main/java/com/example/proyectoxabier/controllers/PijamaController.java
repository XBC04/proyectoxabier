package com.example.proyectoxabier.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.proyectoxabier.models.Pijama;
import com.example.proyectoxabier.services.PijamaService;

@Controller
public class PijamaController {

    @Autowired
    private PijamaService pijamaService;

    @GetMapping("/pijamas")
    public String listarPijamas(Model model) {
        List<Pijama> pijamas = pijamaService.obtenerTodos();
        model.addAttribute("pijamas", pijamas);
        return "pijamas";
    }
}
