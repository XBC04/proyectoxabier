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

import com.example.proyectoxabier.models.Bebe;
import com.example.proyectoxabier.services.BebeService;

@RestController
@RequestMapping("/api/bebes")
public class BebeRestController {

    @Autowired
    private BebeService bebeService;

    @GetMapping
    public List<Bebe> listarBebes() {
        return bebeService.obtenerTodos();
    }

    @PostMapping
    public ResponseEntity<Bebe> crearBebe(@RequestBody Bebe bebe) {
        Bebe nuevoBebe = bebeService.guardarBebe(bebe);
        return new ResponseEntity<>(nuevoBebe, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Bebe> obtenerBebePorId(@PathVariable Long id) {
        Optional<Bebe> bebe = bebeService.obtenerPorId(id);
        if (bebe.isPresent()) {
            return ResponseEntity.ok(bebe.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
