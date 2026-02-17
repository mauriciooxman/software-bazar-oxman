package com.example.bazar_todo_code.service;

import com.example.bazar_todo_code.model.Producto;

import java.util.List;

public interface IProductoService {

    public List<Producto> listProducto();
    public void saveProducto(Producto producto);
    public Producto findProductoById(Long codigo_producto);
    public void deleteProducto(Long condigo_producto);
    public Producto editProducto(Producto producto);
    public List<Producto> getProductosFaltaStock();

}
