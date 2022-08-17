package com.crud.reactivo.CruddeProductos.servicio;

import com.crud.reactivo.CruddeProductos.modelo.Producto;
import com.crud.reactivo.CruddeProductos.repositorio.ProductoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProductoServiceImp implements ProductoService{

    @Autowired
    ProductoRepositorio repositorio;
    @Override
    public Mono<Producto> save(Producto producto) {
        return this.repositorio.save(producto);
    }

    @Override
    public Mono<Producto> delete(String id) {
        return null;
    }

    @Override
    public Mono<Producto> update(String id, Producto producto) {
        return null;
    }

    @Override
    public Flux<Producto> findAll() {
        return this.repositorio.findAll();
    }

    @Override
    public Mono<Producto> findById(String id) {
        return this.repositorio;
    }
}
