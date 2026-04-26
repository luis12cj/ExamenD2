package com.upiiz.ExamenU2.repositories;

import com.upiiz.ExamenU2.entities.Venta;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VentaRepository extends ListCrudRepository<Venta, Long> {
}