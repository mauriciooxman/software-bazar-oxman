package com.example.bazar_todo_code.service;

import com.example.bazar_todo_code.dto.MayorVentaDto;
import com.example.bazar_todo_code.dto.VentaDiariaDto;
import com.example.bazar_todo_code.model.Producto;
import com.example.bazar_todo_code.model.Venta;
import com.example.bazar_todo_code.repository.IVentaRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class VentaService implements IVentaService {
    private final IVentaRepository ventaRepository;

    public VentaService(IVentaRepository ventaRepository) {
        this.ventaRepository = ventaRepository;
    }

    @Override
    public List<Venta> listVentas() {
        List<Venta> listVentas = ventaRepository.findAll();
        return listVentas;
    }

    @Override
    public Venta getVentaById(Long codigo_venta) {
        Venta venta = ventaRepository.findById(codigo_venta).orElse(null);
        return venta;
    }

    @Override
    public void saveVenta(Venta venta) {
        ventaRepository.save(venta);
    }


    @Override
    public void deleteVenta(Long codigo_venta) {
        ventaRepository.deleteById(codigo_venta);
    }

    @Override
    public Venta editVenta(Venta venta) {
        Venta VentaExistente = getVentaById(venta.getCodigo_venta());
        if (VentaExistente == null) {
            return null;
        }
        VentaExistente.setCodigo_venta(venta.getCodigo_venta());
        VentaExistente.setFecha_venta(venta.getFecha_venta());
        VentaExistente.setTotal(venta.getTotal());
        VentaExistente.setUnCliente(venta.getUnCliente());
        VentaExistente.setListaProductos(venta.getListaProductos());


        return ventaRepository.save(VentaExistente);
    }

    @Override
    public List<Producto> getProductosByVenta(Long codigo_venta) {
        Venta venta = ventaRepository.findById(codigo_venta).orElse(null);
        if (venta != null) {
            return venta.getListaProductos();
        }
        return new ArrayList<>();
    }

    @Override
    public String getSumatoriaVentasPorFecha(LocalDate fecha_venta) {
        List<Venta> todasLasVentas = ventaRepository.findAll();
        double sumaMonto = 0;
        int cantidadVentas = 0;
        for (Venta venta : todasLasVentas) {
            // Comparamos si la fecha es igual a la solicitada
            if (venta.getFecha_venta().equals(fecha_venta)) {
                sumaMonto = sumaMonto + venta.getTotal();
                cantidadVentas++;
            }
        }
        return "Dia: " + fecha_venta + " | Monto total: " + sumaMonto + " | Cantidad de ventas: " + cantidadVentas;
    }

    @Override
    public MayorVentaDto getMayorVenta() {
        List<Venta> listaVentas = this.listVentas();
        Venta mayorVenta = null;

        // 2. Lógica para encontrar el máximo
        for (Venta venta : listaVentas) {
            // ERROR CORREGIDO: Aquí se usa "==" para comparar, no "="
            if (mayorVenta == null) {
                mayorVenta = venta;
            } else {
                if (venta.getTotal() > mayorVenta.getTotal()) {
                    mayorVenta = venta;
                }
            }
        }

        // 3. Usamos el NUEVO DTO que sí tiene los campos necesarios
        com.example.bazar_todo_code.dto.MayorVentaDto dto = new com.example.bazar_todo_code.dto.MayorVentaDto();

        if (mayorVenta != null) {
            dto.setCodigo_venta(mayorVenta.getCodigo_venta());
            dto.setTotal(mayorVenta.getTotal());
            dto.setCantidad_productos(mayorVenta.getListaProductos().size()); // Ahora sí funcionará
            dto.setNombre_cliente(mayorVenta.getUnCliente().getNombre());
            dto.setApellido_cliente(mayorVenta.getUnCliente().getApellido());
        }

        return dto;
    }
}