package com.example.proyectoxabier.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.proyectoxabier.models.Ofertas;

public interface OfertasRepository extends JpaRepository<Ofertas, Long> {
    
}
