package com.upiiz.ExamenU2.config;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class SessionInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();

        // Si el usuario NO está en la sesión, lo mandamos al login
        if (session.getAttribute("usuarioLogueado") == null) {
            response.sendRedirect("/auth/login");
            return false;
        }

        return true; // Si está logueado, lo dejamos pasar
    }
}