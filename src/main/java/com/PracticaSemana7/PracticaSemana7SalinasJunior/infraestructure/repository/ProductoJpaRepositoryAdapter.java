package com.PracticaSemana7.PracticaSemana7SalinasJunior.infraestructure.repository;

import com.PracticaSemana7.PracticaSemana7SalinasJunior.domain.model.Producto;
import com.PracticaSemana7.PracticaSemana7SalinasJunior.domain.ports.out.ProductoRepositoryPort;
import com.PracticaSemana7.PracticaSemana7SalinasJunior.infraestructure.entity.ProductoEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class ProductoJpaRepositoryAdapter implements ProductoRepositoryPort {
private final ProductoJpaRepository productoJpaRepository;

    public ProductoJpaRepositoryAdapter(ProductoJpaRepository productoJpaRepository) {
        this.productoJpaRepository = productoJpaRepository;
    }

    @Override
    public List<Producto> findAll() {
        List<ProductoEntity> productosEntity = productoJpaRepository.findAll();
        List<Producto> productos = new ArrayList<>();
        productosEntity.forEach(rproducto->{
            Producto producto=new Producto(rproducto.getId(), rproducto.getNombre(), rproducto.getDescripcion(),rproducto.getPrecio(),rproducto.getEstado(),rproducto.getCategoria_id(),rproducto.getProveedor_id());
            productos.add(producto);

        });
        return productos;
    }

    @Override
    public Optional<Producto> findById(Long id) {
        return productoJpaRepository.findById(id).map(ProductoEntity::toDomainModel);
    }

    @Override
    public Producto save(Producto producto) {
        ProductoEntity productoEntity=ProductoEntity.fromDomainModel(producto);
        ProductoEntity saveProductoEntity = productoJpaRepository.save(productoEntity);
        return saveProductoEntity.toDomainModel();
    }

    @Override
    public Producto update(Producto producto) {
        ProductoEntity productoEntity=ProductoEntity.fromDomainModel(producto);
        ProductoEntity updatedProductoEntity = productoJpaRepository.save(productoEntity);
        return updatedProductoEntity.toDomainModel();
    }

    @Override
    public void delete(Long id) {
            productoJpaRepository.deleteById(id);
    }
}
