package com.crud.reactivo.CruddeProductos.servicio;

import com.crud.reactivo.CruddeProductos.modelo.Producto;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public interface ProductoService {

    //0...1
    Mono<Producto> save(Producto producto);

    Mono<Producto> delete(String id);

    //0...N
    Flux<Producto> findByCategory(String categoria);

    Mono<Producto> update(String id, Producto producto);

    Flux<Producto> findAll();

    Mono<Producto> findById(String id);
}
