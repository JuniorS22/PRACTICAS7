package com.PracticaSemana7.PracticaSemana7SalinasJunior.domain.ports.in;

import com.PracticaSemana7.PracticaSemana7SalinasJunior.domain.model.Producto;

import java.util.List;
import java.util.Optional;

public interface ProductoUseCase {
    List<Producto> buscarTodos();
    Optional<Producto> busPorId(Long id);
    Producto guardar(Producto producto);
    Producto actualizar(Producto producto);
    void   eliminar(Long id);
}
