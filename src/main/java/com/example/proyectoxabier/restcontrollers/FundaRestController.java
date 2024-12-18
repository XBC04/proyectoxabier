package com.example.proyectoxabier.restcontrollers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.proyectoxabier.models.Funda;
import com.example.proyectoxabier.services.FundaService;

@RestController
@RequestMapping("/api/fundas")
public class FundaRestController {

    @Autowired
    private FundaService fundaService;

    @GetMapping
    public List<Funda> listarFundas() {
        return fundaService.obtenerTodas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Funda> obtenerFundaPorId(@PathVariable Long id) {
        Optional<Funda> funda = fundaService.obtenerPorId(id);
        if (funda.isPresent()) {
            return ResponseEntity.ok(funda.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
