package com.upiiz.ExamenU2.controllers;

import com.upiiz.ExamenU2.services.VentaService;
import com.upiiz.ExamenU2.entities.Venta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/facturacion")
public class FacturacionController {

    @Autowired
    private VentaService ventaService;

    // 1. Mostrar la lista de ventas para facturar
    @GetMapping
    public String index(Model model) {
        // Usamos el listarVentas que ya tenías en el service
        model.addAttribute("facturas", ventaService.listarVentas());
        return "facturacion/index";
    }

    // 2. Mostrar el detalle de la factura (invoice.html)
    @GetMapping("/generar/{id}")
    public String generar(@PathVariable Long id, Model model) {
        // Buscamos la venta específica por su ID
        Venta venta = ventaService.listarVentas().stream()
                .filter(v -> v.getId().equals(id))
                .findFirst()
                .orElse(null);

        if (venta != null) {
            model.addAttribute("factura", venta);
            return "facturacion/invoice";
        }

        return "redirect:/facturacion";
    }
}