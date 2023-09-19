package com.PracticaSemana7.PracticaSemana7SalinasJunior.infraestructure.repository;

import com.PracticaSemana7.PracticaSemana7SalinasJunior.domain.model.Producto;
import com.PracticaSemana7.PracticaSemana7SalinasJunior.infraestructure.entity.ProductoEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

class ProductoJpaRepositoryAdapterTest {

    @Mock
    ProductoJpaRepository productoJpaRepository;
    @InjectMocks
    ProductoJpaRepositoryAdapter productoJpaRepositoryAdapter;
    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
        productoJpaRepositoryAdapter=new ProductoJpaRepositoryAdapter(productoJpaRepository);
    }
    @Test
    void findAll() {
        List<ProductoEntity> productoEntidad = new ArrayList<>();
        productoEntidad.add(new ProductoEntity(1L, "Coca Cola", "Gaseosa", 3, 1, 1, 1));
        productoEntidad.add(new ProductoEntity(2L, "Pepsi", "Gaseosa", 2, 1, 1, 1));

        Mockito.when(productoJpaRepository.findAll()).thenReturn(productoEntidad);

        List<Producto> productos = productoJpaRepositoryAdapter.findAll();

        Assertions.assertEquals(productoEntidad.size(), productos.size());

        for (int i = 0; i < productoEntidad.size(); i++) {
            ProductoEntity productoEntity = productoEntidad.get(i);
            Producto producto = productos.get(i);

            Assertions.assertEquals(productoEntity.getId(), producto.getId());
            Assertions.assertEquals(productoEntity.getNombre(), producto.getNombre());
            Assertions.assertEquals(productoEntity.getDescripcion(), producto.getDescripcion());
            Assertions.assertEquals(productoEntity.getPrecio(), producto.getPrecio());
            Assertions.assertEquals(productoEntity.getEstado(), producto.getEstado());
            Assertions.assertEquals(productoEntity.getCategoria_id(), producto.getCategoria_id());
            Assertions.assertEquals(productoEntity.getProveedor_id(), producto.getProveedor_id());
        }
    }

    @Test
    void findById() {
        Long id=1L;
        ProductoEntity productoEntity=new ProductoEntity(1L,"coca cola","gaseosa helada",3,1,1,1);
        Mockito.when(productoJpaRepository.findById(id)).thenReturn(Optional.of(productoEntity));
        Optional<Producto> producto=productoJpaRepositoryAdapter.findById(id);
        Assertions.assertNotNull(producto);
        producto.map(producto1 -> {
            Assertions.assertEquals(productoEntity.getId(),producto1.getId());
            return true;
        });
    }

    @Test
    void saveExitoso() {
        Producto producto=new Producto(1L,"coca cola","gaseosa helada",3,1,1,1);
        ProductoEntity productoEntity=new ProductoEntity(1L,"coca cola","gaseosa helada",3,1,1,1);
        Mockito.when(productoJpaRepository.save(Mockito.any(ProductoEntity.class))).thenReturn(productoEntity);
        Producto productoAdapter=productoJpaRepositoryAdapter.save(producto);
        Assertions.assertNotNull(productoAdapter);
        Assertions.assertEquals(producto.getId(),productoAdapter.getId());
        Assertions.assertEquals(producto.getNombre(),productoAdapter.getNombre());

    }

    @Test
    void updateExitoso() {
        Producto producto=new Producto(1L,"coca cola","gaseosa helada",3,1,1,1);
        ProductoEntity productoEntity=new ProductoEntity(1L,"coca cola","gaseosa helada",3,1,1,1);
        Mockito.when(productoJpaRepository.save(Mockito.any(ProductoEntity.class))).thenReturn(productoEntity);
        Producto productoAdapter=productoJpaRepositoryAdapter.update(producto);
        Assertions.assertNotNull(productoAdapter);
        Assertions.assertEquals(producto.getId(),productoAdapter.getId());
        Assertions.assertEquals(producto.getNombre(),productoAdapter.getNombre());
    }

    @Test
    void deleteExitoso() {
        Long id=1L;
        productoJpaRepositoryAdapter.delete(id);
    }
}