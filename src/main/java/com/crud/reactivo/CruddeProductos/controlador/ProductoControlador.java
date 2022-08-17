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
    private Mono<Producto> save(@RequestBody Producto producto){
        return this.productoService.save(producto);
    }
    @GetMapping("/productos")
    public Flux<Producto> findAll(){
        return productoService.findAll();
    }



}
