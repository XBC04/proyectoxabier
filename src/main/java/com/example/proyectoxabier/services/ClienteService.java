package com.example.proyectoxabier.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.proyectoxabier.models.Cliente;
import com.example.proyectoxabier.repositories.ClienteRepository;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente registrarCliente(String nombre, String email, String password) {
        Cliente cliente = new Cliente();
        cliente.setNombre(nombre);
        cliente.setEmail(email);
        cliente.setPassword(password);

        return clienteRepository.save(cliente);
    }
}
