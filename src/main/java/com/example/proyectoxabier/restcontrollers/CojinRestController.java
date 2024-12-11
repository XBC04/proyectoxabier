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

import com.example.proyectoxabier.models.Cojin;
import com.example.proyectoxabier.services.CojinService;

@RestController
@RequestMapping("/api/cojines")
public class CojinRestController {

    @Autowired
    private CojinService cojinService;

    @GetMapping
    public List<Cojin> listarCojines() {
        return cojinService.obtenerTodos();
    }

    @PostMapping
    public ResponseEntity<Cojin> crearCojin(@RequestBody Cojin cojin) {
        Cojin nuevoCojin = cojinService.guardarCojin(cojin);
        return new ResponseEntity<>(nuevoCojin, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cojin> obtenerCojinPorId(@PathVariable Long id) {
        Optional<Cojin> cojin = cojinService.obtenerPorId(id);
        if (cojin.isPresent()) {
            return ResponseEntity.ok(cojin.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}