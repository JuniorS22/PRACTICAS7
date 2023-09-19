package com.PracticaSemana7.PracticaSemana7SalinasJunior.domain.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Producto {
private Long id;
private String nombre;
private String descripcion;
private double precio;
private int estado;
private int categoria_id;
private int proveedor_id;

    public Producto(Long id, String nombre, String descripcion, double precio, int estado, int categoria_id, int proveedor_id) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.estado = estado;
        this.categoria_id = categoria_id;
        this.proveedor_id = proveedor_id;
    }
}
