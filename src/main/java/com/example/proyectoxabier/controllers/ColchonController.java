package com.example.proyectoxabier.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
}