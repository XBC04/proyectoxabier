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

import com.example.proyectoxabier.models.Colchon;
import com.example.proyectoxabier.services.ColchonService;

@RestController
@RequestMapping("/api/colchones")
public class ColchonRestController {

    @Autowired
    private ColchonService colchonService;

    @GetMapping
    public List<Colchon> listarColchones() {
        return colchonService.obtenerTodos();
    }

    @PostMapping
    public ResponseEntity<Colchon> crearColchon(@RequestBody Colchon colchon) {
        Colchon nuevoColchon = colchonService.guardarColchon(colchon);
        return new ResponseEntity<>(nuevoColchon, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Colchon> obtenerColchonPorId(@PathVariable Long id) {
        Optional<Colchon> colchon = colchonService.obtenerPorId(id);
        if (colchon.isPresent()) {
            return ResponseEntity.ok(colchon.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
