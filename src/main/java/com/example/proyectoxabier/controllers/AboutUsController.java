package com.example.proyectoxabier.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AboutUsController {
    @GetMapping("/about-us")
    public String mostrarSobreNosotros() {
        return "about_us"; // 
    }
}