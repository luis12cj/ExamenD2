package com.upiiz.ExamenU2.entities;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import java.time.LocalDate;

@Data
@Table("ventas")
public class Venta {
    @Id
    private Long id;
    private Long libroId; // Esto es lo que captura el <select>
    private String cliente;
    private Integer cantidad;
    private LocalDate fecha = LocalDate.now();
}