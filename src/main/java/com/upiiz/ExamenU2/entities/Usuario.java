package com.upiiz.ExamenU2.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import lombok.Data;

@Data
@Table("usuarios")
public class Usuario {
    @Id
    private Long id;
    private String nombre;
    private String email;
    private String password;
}