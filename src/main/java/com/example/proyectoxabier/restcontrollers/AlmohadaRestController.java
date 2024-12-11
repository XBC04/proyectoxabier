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

import com.example.proyectoxabier.models.Almohada;
import com.example.proyectoxabier.services.AlmohadaService;

@RestController
@RequestMapping("/api/almohadas")
public class AlmohadaRestController {

    @Autowired
    private AlmohadaService almohadaService;

    @GetMapping
    public List<Almohada> listarAlmohadas() {
        return almohadaService.obtenerTodas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Almohada> obtenerAlmohadaPorId(@PathVariable Long id) {
        Optional<Almohada> almohada = almohadaService.obtenerPorId(id);
        if (almohada.isPresent()) {
            return ResponseEntity.ok(almohada.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Almohada> crearAlmohada(@RequestBody Almohada almohada) {
        Almohada nuevaAlmohada = almohadaService.guardarAlmohada(almohada);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaAlmohada);
    }
}
