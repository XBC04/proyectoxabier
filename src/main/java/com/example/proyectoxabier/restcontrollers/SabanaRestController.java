package com.example.proyectoxabier.restcontrollers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.proyectoxabier.models.Sabana;
import com.example.proyectoxabier.services.SabanaService;

@RestController
@RequestMapping("/api/sabanas")
public class SabanaRestController {

    @Autowired
    private SabanaService sabanaService;

    @GetMapping
    public List<Sabana> listarSabanas() {
        return sabanaService.obtenerTodas();
    }

    @PostMapping
    public ResponseEntity<Sabana> crearSabana(@RequestBody Sabana sabana) {
        Sabana nuevaSabana = sabanaService.guardarSabana(sabana);
        return new ResponseEntity<>(nuevaSabana, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Sabana> obtenerSabanaPorId(@PathVariable Long id) {
        Optional<Sabana> sabana = sabanaService.obtenerPorId(id);
        if (sabana.isPresent()) {
            return ResponseEntity.ok(sabana.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}