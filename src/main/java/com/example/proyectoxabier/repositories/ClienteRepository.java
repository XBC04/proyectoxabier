package com.example.proyectoxabier.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.proyectoxabier.models.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    Cliente findByEmail(String email);
}