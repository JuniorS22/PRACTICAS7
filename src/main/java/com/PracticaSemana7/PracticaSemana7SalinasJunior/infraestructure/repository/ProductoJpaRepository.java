package com.PracticaSemana7.PracticaSemana7SalinasJunior.infraestructure.repository;

import com.PracticaSemana7.PracticaSemana7SalinasJunior.infraestructure.entity.ProductoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoJpaRepository extends JpaRepository<ProductoEntity,Long> {
}
