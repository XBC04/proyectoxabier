package com.example.proyectoxabier.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.proyectoxabier.services.ClienteService;

@Controller
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping("/crear")
    public String mostrarFormulario() {
        return "CrearCuenta"; 
    }

    @PostMapping("/crear")
    public String registrarCliente(@RequestParam String nombre,
                                   @RequestParam String NumOCor,
                                   @RequestParam String password,
                                   Model model) {
        clienteService.registrarCliente(nombre, NumOCor, password);
        return "redirect:/clientes/success";
    }

    @GetMapping("/success")
    public String mostrarExito() {
        return "RegistroExitoso"; 
    }

    @GetMapping("/iniciar-sesion")
    public String mostrarInicioSesion() {
        return "IniciarSesion"; 
    }
}