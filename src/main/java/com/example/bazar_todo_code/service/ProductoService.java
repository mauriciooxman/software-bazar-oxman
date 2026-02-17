package com.example.bazar_todo_code.service;

import com.example.bazar_todo_code.model.Producto;
import com.example.bazar_todo_code.repository.IProductoRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductoService implements IProductoService {
    private final IProductoRepository iProductoRepository;

    public ProductoService(IProductoRepository iProductoRepository) {
        this.iProductoRepository = iProductoRepository;
    }

    @Override
    public List<Producto> listProducto() {
        List<Producto>listProducto = iProductoRepository.findAll();
        return listProducto;
    }

    @Override
    public void saveProducto(Producto producto) {
        iProductoRepository.save(producto);

    }

    @Override
    public Producto findProductoById(Long codigo_producto) {
        Producto producto = iProductoRepository.findById(codigo_producto).orElse(null);
        return producto;
    }

    @Override
    public void deleteProducto(Long condigo_producto) {
    iProductoRepository.deleteById(condigo_producto);
    }

    @Override
    public Producto editProducto(Producto producto) {
        Producto ProductoExistente = findProductoById(producto.getCodigo_producto());
        if(ProductoExistente == null) {
            return null;
        }

        ProductoExistente.setCodigo_producto(producto.getCodigo_producto());
        ProductoExistente.setCosto(producto.getCosto());
        ProductoExistente.setNombre(producto.getNombre());
        ProductoExistente.setMarca(producto.getMarca());
        ProductoExistente.setCantidad_disponible(producto.getCantidad_disponible());

        return iProductoRepository.save(ProductoExistente);

    }



    @Override
    public List<Producto> getProductosFaltaStock() {
        //traemos todos los productos
        this.listProducto();
        //traer una lista vacia para rellenar los productos con poco stock
        List<Producto> productosConPocoStock = new ArrayList<>();
        //iteramos con un blucle for
        for(Producto producto : listProducto()){
            if(producto.getCantidad_disponible() < 5){
                productosConPocoStock.add(producto);
            }
        }
        return productosConPocoStock;
    }

}
