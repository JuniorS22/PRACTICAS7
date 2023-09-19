package com.PracticaSemana7.PracticaSemana7SalinasJunior.infraestructure.controller;


import com.PracticaSemana7.PracticaSemana7SalinasJunior.application.service.ProductoService;
import com.PracticaSemana7.PracticaSemana7SalinasJunior.domain.model.Producto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/productos")
public class ProductoController {
    private final ProductoService productoService;

    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    @GetMapping()
    public ResponseEntity<List<Producto>> getProductos(){
        if (!productoService.buscarTodos().isEmpty()){
            return new ResponseEntity<>(productoService.buscarTodos(),HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @PostMapping
    public ResponseEntity<Producto> createProducto(@RequestBody Producto producto){
        Producto createProducto=productoService.guardar(producto);
        return new ResponseEntity<>(createProducto, HttpStatus.CREATED);
    }
    @GetMapping("/{productoId}")
    public ResponseEntity<Producto> getProdcutoById(@PathVariable Long productoId){
        return productoService.busPorId(productoId).map(producto -> new ResponseEntity<>(producto,HttpStatus.OK) ).
                orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @PutMapping
    public ResponseEntity<Producto> updateProducto(@RequestBody Producto producto){
        Producto actualizarProducto=productoService.actualizar(producto);
        return new ResponseEntity<>(actualizarProducto, HttpStatus.CREATED);
    }
    @DeleteMapping("/{productoId}")
    public ResponseEntity<String> deleteProducto(@PathVariable Long productoId){
        productoService.eliminar(productoId);
        return new ResponseEntity<>("Producto eliminado con exito", HttpStatus.OK);
    }
}
