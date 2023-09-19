package com.PracticaSemana7.PracticaSemana7SalinasJunior.infraestructure.entity;

import com.PracticaSemana7.PracticaSemana7SalinasJunior.domain.model.Producto;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name="producto")
public class ProductoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String descripcion;
    private double precio;
    private int estado;
    private int categoria_id;
    private int proveedor_id;

    public ProductoEntity() {
    }

    public ProductoEntity(Long id, String nombre, String descripcion, double precio, int estado, int categoria_id, int proveedor_id) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.estado = estado;
        this.categoria_id = categoria_id;
        this.proveedor_id = proveedor_id;
    }

    public static ProductoEntity fromDomainModel(Producto producto){
        return new ProductoEntity(producto.getId(), producto.getNombre(), producto.getDescripcion(), producto.getPrecio(), producto.getEstado(), producto.getCategoria_id(), producto.getProveedor_id());
    }
    public Producto toDomainModel(){
        return new Producto(id,nombre,descripcion,precio,estado,categoria_id,proveedor_id);
    }
}
