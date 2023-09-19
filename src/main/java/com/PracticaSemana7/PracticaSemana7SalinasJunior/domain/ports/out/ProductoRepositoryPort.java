package com.PracticaSemana7.PracticaSemana7SalinasJunior.domain.ports.out;

import com.PracticaSemana7.PracticaSemana7SalinasJunior.domain.model.Producto;

import java.util.List;
import java.util.Optional;

public interface ProductoRepositoryPort {
    List<Producto> findAll();
    Optional<Producto> findById(Long id);
    Producto save(Producto producto);
    Producto update(Producto producto);
    void   delete(Long id);
}
