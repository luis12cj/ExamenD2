package com.upiiz.ExamenU2.services;

import com.upiiz.ExamenU2.entities.Libro;
import com.upiiz.ExamenU2.repositories.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class LibroService {
    @Autowired
    private LibroRepository libroRepository;

    public List<Libro> listarLibros() { return libroRepository.findAll(); }
    public Libro guardarLibro(Libro libro) { return libroRepository.save(libro); }
    public Libro obtenerLibroPorId(Long id) { return libroRepository.findById(id).orElse(null); }
    public void eliminarLibro(Long id) { libroRepository.deleteById(id); }
    public long contarLibros() { return libroRepository.count(); }

}