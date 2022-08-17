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
        return this.repositorio.findById(id)
                .flatMap(p -> this.repositorio.deleteById(p.getId()).thenReturn(p));
    }

    @Override
    public Flux<Producto> findByCategory(String categoria) {
        return this.repositorio.findAll()
                .filter(x -> x.getCategoria() == categoria);
    }

    @Override
    public Mono<Producto> update(String id, Producto producto) {
        return this.repositorio.findById(id)
                .flatMap(pr -> {
                    pr.setId(id);
                    pr.setNombre(producto.getNombre());
                    pr.setPrecio(producto.getPrecio());
                    pr.setCategoria(producto.getCategoria());
                    return save(pr);
                })
                .switchIfEmpty(Mono.empty());
    }

    @Override
    public Flux<Producto> findAll() {
        return this.repositorio.findAll();
    }

    @Override
    public Mono<Producto> findById(String id) {
        return this.repositorio.findById(id);
    }
}
