package com.example.proyectoxabier.models;

import jakarta.persistence.*;

@Entity
public class Ofertas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String descripcion;
    private double precioAntes;
    private double precioAhora;

    // necesario para JPA
    public Ofertas() {}

    public Ofertas(String nombre, String descripcion, double precioAntes, double precioAhora) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precioAntes = precioAntes;
        this.precioAhora = precioAhora;
    }

    public Long getId() { 
        return id; 
    }
    public void setId(Long id) { 
        this.id = id; 
    }

    public String getNombre() { 
        return nombre; 
    }
    public void setNombre(String nombre) { 
        this.nombre = nombre; 
    }

    public String getDescripcion() { 
        return descripcion; 
    }
    public void setDescripcion(String descripcion) { 
        this.descripcion = descripcion; 
    }

    public double getPrecioAntes() { 
        return precioAntes; 
    }
    public void setPrecioAntes(double precioAntes) { 
        this.precioAntes = precioAntes; 
    }

    public double getPrecioAhora() { 
        return precioAhora; 
    }
    public void setPrecioAhora(double precioAhora) { 
        this.precioAhora = precioAhora; 
    }
}
