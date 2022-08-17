package com.crud.reactivo.CruddeProductos.repositorio;

import com.crud.reactivo.CruddeProductos.modelo.Producto;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepositorio extends ReactiveMongoRepository<Producto, String> {
}
