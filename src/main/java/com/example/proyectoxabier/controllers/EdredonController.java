package com.example.proyectoxabier.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
}
