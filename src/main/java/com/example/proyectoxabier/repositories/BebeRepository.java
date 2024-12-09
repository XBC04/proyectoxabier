package com.example.proyectoxabier.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.proyectoxabier.models.Bebe;

public interface BebeRepository extends JpaRepository<Bebe, Long> {
}