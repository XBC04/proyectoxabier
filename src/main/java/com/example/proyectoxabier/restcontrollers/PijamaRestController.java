package com.example.proyectoxabier.restcontrollers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.proyectoxabier.models.Pijama;
import com.example.proyectoxabier.services.PijamaService;

@RestController
@RequestMapping("/api/pijamas")
public class PijamaRestController {

    @Autowired
    private PijamaService pijamaService;

    @GetMapping
    public List<Pijama> listarPijamas() {
        return pijamaService.obtenerTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pijama> obtenerPijamaPorId(@PathVariable Long id) {
        Optional<Pijama> pijama = pijamaService.obtenerPorId(id);
        if (pijama.isPresent()) {
            return ResponseEntity.ok(pijama.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
