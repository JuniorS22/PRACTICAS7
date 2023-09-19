package com.PracticaSemana7.PracticaSemana7SalinasJunior.application.service;

import com.PracticaSemana7.PracticaSemana7SalinasJunior.domain.model.Producto;
import com.PracticaSemana7.PracticaSemana7SalinasJunior.domain.ports.in.ProductoUseCase;

import java.util.List;
import java.util.Optional;

public class ProductoService implements ProductoUseCase {
    private ProductoUseCase productoUseCase;

    public ProductoService(ProductoUseCase productoUseCase) {
        this.productoUseCase = productoUseCase;
    }

    @Override
    public List<Producto> buscarTodos() {
        return productoUseCase.buscarTodos();
    }

    @Override
    public Optional<Producto> busPorId(Long id) {
        return productoUseCase.busPorId(id);
    }

    @Override
    public Producto guardar(Producto producto) {
        return productoUseCase.guardar(producto);
    }

    @Override
    public Producto actualizar(Producto producto) {
        return productoUseCase.actualizar(producto);
    }

    @Override
    public void eliminar(Long id) {
productoUseCase.eliminar(id);
    }


}
