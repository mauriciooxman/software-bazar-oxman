package com.example.bazar_todo_code.controller;

import com.example.bazar_todo_code.dto.MayorVentaDto;
import com.example.bazar_todo_code.model.Producto;
import com.example.bazar_todo_code.model.Venta;
import com.example.bazar_todo_code.service.VentaService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/ventas")
public class VentaController {
 private final VentaService ventaService;

    public VentaController(VentaService ventaService) {
        this.ventaService = ventaService;
    }

    @GetMapping("/")
    public List<Venta> listasVentas(){
        return ventaService.listVentas();
    }

    @GetMapping("/{id}")
    public Venta getVentaById(@PathVariable Long codigo_venta){
       return ventaService.getVentaById(codigo_venta);
    }

    @GetMapping("/ventas/productos/{codigo_venta}")
    public List<Producto> getProductosDeVenta(@PathVariable Long codigo_venta) {
        return ventaService.getProductosByVenta(codigo_venta);
    }
    @GetMapping("/ventas/{fecha_venta}")
    public String getSumatoriaVentasDia(@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fecha_venta) {
        return ventaService.getSumatoriaVentasPorFecha(fecha_venta);
    }
    @GetMapping("/ventas/mayor_venta")
    public MayorVentaDto getMayorVenta() {
        return ventaService.getMayorVenta();
    }

    @PostMapping("/crear")
    public void saveVenta(@RequestBody Venta venta) {
        ventaService.saveVenta(venta);
    }

    @DeleteMapping("/{id}")
    public void deleteVenta(@PathVariable Long codigo_venta){
        ventaService.deleteVenta(codigo_venta);
    }

    @PutMapping("/editar")
    public Venta editarVenta(@RequestBody Venta venta){
        return ventaService.editVenta(venta);

    }

}
