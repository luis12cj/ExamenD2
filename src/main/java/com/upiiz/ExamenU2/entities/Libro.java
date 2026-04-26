package com.upiiz.ExamenU2.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import lombok.Data;

@Data
@Table("libros")
public class Libro {
    @Id
    private Long id;

    private String titulo;
    private String autor;
    private Double precio;
    private Integer stock;
}