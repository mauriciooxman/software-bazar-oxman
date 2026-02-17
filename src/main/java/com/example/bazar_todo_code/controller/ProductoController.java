package com.example.bazar_todo_code.controller;



import com.example.bazar_todo_code.model.Producto;
import com.example.bazar_todo_code.service.ProductoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/productos")
public class ProductoController {
    public final ProductoService productoService;

    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    @GetMapping
    public List<Producto> listasProductos(){
        return productoService.listProducto();
    }

    @GetMapping("/{id}")
    public Producto getProductoById(@PathVariable Long codigo_producto){
       return productoService.findProductoById(codigo_producto);
    }
    @GetMapping("/productos/falta_stock")
    public List<Producto> getProductosFaltaStock() {
        return productoService.getProductosFaltaStock();
    }

    @PostMapping("/crear")
    public void saveProducto(@RequestBody Producto producto){
        productoService.saveProducto(producto);
    }
    @DeleteMapping("/{id}")
    public void deleteProducto(@PathVariable Long codigo_producto){
        productoService.deleteProducto(codigo_producto);
    }
}
