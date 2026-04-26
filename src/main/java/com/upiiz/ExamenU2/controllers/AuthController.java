package com.upiiz.ExamenU2.controllers;

import com.upiiz.ExamenU2.entities.Usuario;
import com.upiiz.ExamenU2.services.UsuarioService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/login")
    public String login() {
        return "usuarios/login";
    }

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "usuarios/register";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute Usuario usuario, Model model) {
        // Validación de correo duplicado para evitar página blanca
        if (usuarioService.buscarPorEmail(usuario.getEmail()) != null) {
            model.addAttribute("error", "Este correo ya está registrado");
            return "usuarios/register";
        }
        usuarioService.guardarUsuario(usuario);
        return "redirect:/auth/login?exito";
    }

    @PostMapping("/login")
    public String loginUser(@RequestParam("email") String email,
                            @RequestParam("password") String password,
                            HttpSession session,
                            Model model) {

        Usuario u = usuarioService.buscarPorEmail(email.trim());

        if (u != null && u.getPassword().equals(password.trim())) {
            session.setAttribute("usuarioLogueado", u);
            return "redirect:/dashboard";
        }

        model.addAttribute("error", "Correo o contraseña incorrectos");
        return "usuarios/login";
    }

    @GetMapping("/forgot-password")
    public String forgotPasswordForm() {
        return "usuarios/forgot-password";
    }

    @PostMapping("/forgot-password")
    public String processForgotPassword(@RequestParam("email") String email, Model model) {
        model.addAttribute("mensaje", "Se ha enviado un enlace a " + email);
        return "usuarios/forgot-password";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/auth/login";
    }
}