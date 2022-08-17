package com.crud.reactivo.CruddeProductos.controlador;

import com.crud.reactivo.CruddeProductos.modelo.Producto;
import com.crud.reactivo.CruddeProductos.servicio.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class ProductoControlador {

    @Autowired
    ProductoService productoService;

    @PostMapping("/productos")
    private Mono<Producto> save(@RequestBody Producto producto) {
        return this.productoService.save(producto);
    }

    @GetMapping("/productos")
    public Flux<Producto> findAll() {
        return this.productoService.findAll();
    }

    @GetMapping("/producto/{id}")
    public Mono<Producto> findById(@PathVariable("id") String id) {
        return this.productoService.findById(id);
    }

    @GetMapping("/producto/{categoria}")
    public Flux<Producto> productosByCategoria(@PathVariable("categoria") String categoria, @RequestBody Producto producto) {
        return this.productoService.findByCategory(categoria);
    }

    @PutMapping("/producto/{id}")
    public Mono<ResponseEntity<Producto>> update(@PathVariable("id") String id, @RequestBody Producto producto) {
        return this.productoService.update(id, producto)
                .flatMap(producto1 -> Mono.just(ResponseEntity.ok(producto1)))
                .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));
    }

    @DeleteMapping("/producto/{id}")
    private Mono<Producto> delete(@PathVariable("id") String id) {
        return this.productoService.delete(id);
    }
}
