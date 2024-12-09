package com.example.proyectoxabier.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
}