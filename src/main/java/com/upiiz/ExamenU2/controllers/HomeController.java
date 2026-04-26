package com.upiiz.ExamenU2.controllers;

import com.upiiz.ExamenU2.services.LibroService;
import com.upiiz.ExamenU2.services.UsuarioService;
import com.upiiz.ExamenU2.services.VentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @Autowired
    private LibroService libroService;

    @Autowired
    private VentaService ventaService;

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        model.addAttribute("totalVentas", ventaService.contarVentas());
        model.addAttribute("totalLibros", libroService.contarLibros());
        model.addAttribute("totalUsuarios", usuarioService.contarUsuarios());

        String datosVentas = "[0, 0, 0, 0, 0, 0, 0]";
        model.addAttribute("datosGrafica", datosVentas);

        return "home/index";
    }
}