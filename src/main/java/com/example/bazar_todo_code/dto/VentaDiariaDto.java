package com.example.bazar_todo_code.dto;



import java.time.LocalDate;

public class VentaDiariaDto {

    private LocalDate fecha_venta;
    private double montoTotal;
    private int cantidadVentas;

    public VentaDiariaDto(LocalDate fecha_venta, double montoTotal, int cantidadVentas) {
        this.fecha_venta = fecha_venta;
        this.montoTotal = montoTotal;
        this.cantidadVentas = cantidadVentas;
    }

    public LocalDate getFecha_venta() {
        return fecha_venta;
    }

    public void setFecha_venta(LocalDate fecha_venta) {
        this.fecha_venta = fecha_venta;
    }

    public double getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(double montoTotal) {
        this.montoTotal = montoTotal;
    }

    public int getCantidadVentas() {
        return cantidadVentas;
    }

    public void setCantidadVentas(int cantidadVentas) {
        this.cantidadVentas = cantidadVentas;
    }
}
