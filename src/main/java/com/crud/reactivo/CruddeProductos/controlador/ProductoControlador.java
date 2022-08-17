package com.crud.reactivo.CruddeProductos.controlador;

import com.crud.reactivo.CruddeProductos.modelo.Producto;
import com.crud.reactivo.CruddeProductos.servicio.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
//@RequestMapping("/productos")
public class ProductoControlador {

    @Autowired
    ProductoService productoService;

    @PostMapping("/productos")
    private Mono<Producto> save(@RequestBody Producto producto) {
        return this.productoService.save(producto);
    }

    @GetMapping(value = "/productos")
    public Flux<Producto> findAll() {
        return this.productoService.findAll();
    }

    @GetMapping(value = "/producto/{id}")
    public Mono<Producto> findById(@PathVariable("id") String id) {
        return this.productoService.findById(id);

    }
    @GetMapping(value = "/productos/{categoria}")
    public Flux<Producto> productosByCategoria(@PathVariable("categoria") String categoria) {
        return this.productoService.findByCategory(categoria);
    }

    @PutMapping("/update")
    public Mono<Producto> update(@PathVariable("id") String id, @RequestBody Producto producto) {
        return this.productoService.update(id, producto);

    }

    @DeleteMapping("/producto/{id}")
    private Mono<Producto> delete(@PathVariable("id") String id) {
        return this.productoService.delete(id);
    }
}
