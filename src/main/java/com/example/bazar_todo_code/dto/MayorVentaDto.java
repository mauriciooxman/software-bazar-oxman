package com.example.bazar_todo_code.dto;

public class MayorVentaDto { // Nombre nuevo para no confundirse

    private Long codigo_venta;
    private Double total;
    private int cantidad_productos;
    private String nombre_cliente;
    private String apellido_cliente;

    public MayorVentaDto() {
    }

    // Getters y Setters OBLIGATORIOS
    public Long getCodigo_venta() { return codigo_venta; }
    public void setCodigo_venta(Long codigo_venta) { this.codigo_venta = codigo_venta; }

    public Double getTotal() { return total; }
    public void setTotal(Double total) { this.total = total; }

    public int getCantidad_productos() { return cantidad_productos; }
    public void setCantidad_productos(int cantidad_productos) { this.cantidad_productos = cantidad_productos; }

    public String getNombre_cliente() { return nombre_cliente; }
    public void setNombre_cliente(String nombre_cliente) { this.nombre_cliente = nombre_cliente; }

    public String getApellido_cliente() { return apellido_cliente; }
    public void setApellido_cliente(String apellido_cliente) { this.apellido_cliente = apellido_cliente; }
}