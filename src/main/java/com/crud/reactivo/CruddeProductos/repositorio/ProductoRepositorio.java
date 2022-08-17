package com.crud.reactivo.CruddeProductos.repositorio;

import com.crud.reactivo.CruddeProductos.modelo.Producto;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface ProductoRepositorio extends ReactiveMongoRepository<Producto, String> {

}
