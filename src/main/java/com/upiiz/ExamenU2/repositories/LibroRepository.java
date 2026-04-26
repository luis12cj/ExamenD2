package com.upiiz.ExamenU2.repositories;

import com.upiiz.ExamenU2.entities.Libro;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibroRepository extends ListCrudRepository<Libro, Long> {

}