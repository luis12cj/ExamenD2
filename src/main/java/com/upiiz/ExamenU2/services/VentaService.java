package com.upiiz.ExamenU2.services;

import com.upiiz.ExamenU2.entities.Venta;
import com.upiiz.ExamenU2.repositories.VentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class VentaService {
    @Autowired
    private VentaRepository ventaRepository;

    public List<Venta> listarVentas() { return ventaRepository.findAll(); }
    public Venta guardarVenta(Venta venta) { return ventaRepository.save(venta); }
    public void eliminarVenta(Long id) { ventaRepository.deleteById(id); }
    public long contarVentas() { return ventaRepository.count(); }
}