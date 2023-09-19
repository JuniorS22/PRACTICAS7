package com.PracticaSemana7.PracticaSemana7SalinasJunior.application.usecase;

import com.PracticaSemana7.PracticaSemana7SalinasJunior.domain.model.Producto;
import com.PracticaSemana7.PracticaSemana7SalinasJunior.domain.ports.in.ProductoUseCase;
import com.PracticaSemana7.PracticaSemana7SalinasJunior.domain.ports.out.ProductoRepositoryPort;

import java.util.List;
import java.util.Optional;

public class ProductoUseCaseImpl implements ProductoUseCase {
private final ProductoRepositoryPort productoRepositoryPort;

    public ProductoUseCaseImpl(ProductoRepositoryPort productoRepositoryPort) {
        this.productoRepositoryPort = productoRepositoryPort;
    }

    @Override
    public List<Producto> buscarTodos() {
        return productoRepositoryPort.findAll();
    }

    @Override
    public Optional<Producto> busPorId(Long id) {
        return productoRepositoryPort.findById(id);
    }

    @Override
    public Producto guardar(Producto producto) {
        return productoRepositoryPort.save(producto);
    }

    @Override
    public Producto actualizar(Producto producto) {
        return productoRepositoryPort.update(producto);
    }

    @Override
    public void eliminar(Long id) {
        productoRepositoryPort.delete(id);
    }
}
