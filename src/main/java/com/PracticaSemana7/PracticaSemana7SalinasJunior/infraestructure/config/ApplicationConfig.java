package com.PracticaSemana7.PracticaSemana7SalinasJunior.infraestructure.config;

import com.PracticaSemana7.PracticaSemana7SalinasJunior.application.service.ProductoService;
import com.PracticaSemana7.PracticaSemana7SalinasJunior.application.usecase.ProductoUseCaseImpl;
import com.PracticaSemana7.PracticaSemana7SalinasJunior.domain.ports.out.ProductoRepositoryPort;
import com.PracticaSemana7.PracticaSemana7SalinasJunior.infraestructure.repository.ProductoJpaRepositoryAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {
    @Bean
    public ProductoService productoService(ProductoRepositoryPort productoRepositoryPort){
        return new ProductoService(new ProductoUseCaseImpl(productoRepositoryPort));

    }
    @Bean
    public ProductoRepositoryPort productoRepositoryPort(ProductoJpaRepositoryAdapter productoJpaRepositoryAdapter){
        return productoJpaRepositoryAdapter;
    }
}
