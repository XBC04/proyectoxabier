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

import com.example.proyectoxabier.models.Edredon;
import com.example.proyectoxabier.services.EdredonService;

@RestController
@RequestMapping("/api/edredones")
public class EdredonRestController {

    @Autowired
    private EdredonService edredonService;

    @GetMapping
    public List<Edredon> listarEdredones() {
        return edredonService.obtenerTodos();
    }

    @PostMapping
    public ResponseEntity<Edredon> crearEdredon(@RequestBody Edredon edredon) {
        Edredon nuevoEdredon = edredonService.guardarEdredon(edredon);
        return new ResponseEntity<>(nuevoEdredon, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Edredon> obtenerEdredonPorId(@PathVariable Long id) {
        Optional<Edredon> edredon = edredonService.obtenerPorId(id);
        if (edredon.isPresent()) {
            return ResponseEntity.ok(edredon.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}