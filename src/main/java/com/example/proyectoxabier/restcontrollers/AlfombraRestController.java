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

import com.example.proyectoxabier.models.Alfombra;
import com.example.proyectoxabier.services.AlfombraService;

@RestController
@RequestMapping("/api/alfombras")
public class AlfombraRestController {

    @Autowired
    private AlfombraService alfombraService;

    @GetMapping
    public List<Alfombra> listarAlfombras() {
        return alfombraService.obtenerTodas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Alfombra> obtenerAlfombraPorId(@PathVariable Long id) {
        Optional<Alfombra> alfombra = alfombraService.obtenerPorId(id);
        if (alfombra.isPresent()) {
            return ResponseEntity.ok(alfombra.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Alfombra> crearAlfombra(@RequestBody Alfombra alfombra) {
        Alfombra nuevaAlfombra = alfombraService.guardarAlfombra(alfombra);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaAlfombra);
    }
}
