package com.upiiz.ExamenU2.controllers;

import com.upiiz.ExamenU2.entities.Venta;
import com.upiiz.ExamenU2.services.LibroService;
import com.upiiz.ExamenU2.services.VentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/ventas")
public class VentaController {

    @Autowired
    private VentaService ventaService;

    @Autowired
    private LibroService libroService;

    @GetMapping
    public String index(Model model) {
        model.addAttribute("ventas", ventaService.listarVentas());
        return "ventas/index";
    }

    @GetMapping("/nuevo")
    public String create(Model model) {
        model.addAttribute("venta", new Venta());
        model.addAttribute("libros", libroService.listarLibros());
        return "ventas/create";
    }

    @PostMapping("/guardar")
    public String save(@ModelAttribute Venta venta) {
        ventaService.guardarVenta(venta);
        return "redirect:/ventas";
    }

    @GetMapping("/eliminar/{id}")
    public String delete(@PathVariable Long id) {
        ventaService.eliminarVenta(id);
        return "redirect:/ventas";
    }
}