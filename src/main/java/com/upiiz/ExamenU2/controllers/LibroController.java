package com.upiiz.ExamenU2.controllers;

import com.upiiz.ExamenU2.entities.Libro;
import com.upiiz.ExamenU2.services.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/libros")
public class LibroController {

    @Autowired
    private LibroService libroService;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("libros", libroService.listarLibros());
        return "libros/libros"; // Nombre de tu HTML de la lista
    }

    @GetMapping("/nuevo")
    public String formularioNuevo(Model model) {
        // Mandamos un objeto vacío para que Thymeleaf lo llene
        model.addAttribute("libro", new Libro());
        model.addAttribute("tituloPagina", "Agregar Nuevo Libro");
        return "libros/form"; // Nombre de tu HTML del formulario
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute("libro") Libro libro, Model model) {
        try {
            // Validación básica antes de guardar
            if (libro.getTitulo() == null || libro.getTitulo().isEmpty()) {
                model.addAttribute("error", "El título no puede estar vacío");
                return "libros/form";
            }
            libroService.guardarLibro(libro);
            return "redirect:/libros?exito";
        } catch (Exception e) {
            model.addAttribute("error", "Error al guardar: " + e.getMessage());
            return "libros/form";
        }
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        Libro libro = libroService.obtenerLibroPorId(id);
        if (libro != null) {
            model.addAttribute("libro", libro);
            model.addAttribute("tituloPagina", "Editar Libro");
            return "libros/form";
        }
        return "redirect:/libros?error=no_encontrado";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {
        try {
            libroService.eliminarLibro(id);
            return "redirect:/libros?eliminado";
        } catch (Exception e) {
            return "redirect:/libros?error=en_uso";
        }
    }
}