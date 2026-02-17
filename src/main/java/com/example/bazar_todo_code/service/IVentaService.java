package com.example.bazar_todo_code.service;

import com.example.bazar_todo_code.dto.MayorVentaDto;
import com.example.bazar_todo_code.dto.VentaDiariaDto;
import com.example.bazar_todo_code.model.Producto;
import com.example.bazar_todo_code.model.Venta;

import java.time.LocalDate;
import java.util.List;

public interface IVentaService {
    public List<Venta> listVentas();
    public void saveVenta(Venta venta);
    public Venta getVentaById(Long codigo_venta);
    public void deleteVenta(Long codigo_venta);
    public Venta editVenta(Venta venta);
    public List<Producto> getProductosByVenta(Long codigo_venta);
    public String getSumatoriaVentasPorFecha(LocalDate fecha_venta);
    public MayorVentaDto getMayorVenta();


}
