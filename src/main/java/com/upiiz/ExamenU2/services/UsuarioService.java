package com.upiiz.ExamenU2.services;

import com.upiiz.ExamenU2.entities.Usuario;
import com.upiiz.ExamenU2.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> listarUsuarios() { return usuarioRepository.findAll(); }
    public Usuario guardarUsuario(Usuario usuario) { return usuarioRepository.save(usuario); }
    public Usuario buscarPorEmail(String email) { return usuarioRepository.findByEmail(email); }
    public long contarUsuarios() { return usuarioRepository.count(); }
}