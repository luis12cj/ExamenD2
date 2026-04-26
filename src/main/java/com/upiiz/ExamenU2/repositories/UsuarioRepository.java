package com.upiiz.ExamenU2.repositories;

import com.upiiz.ExamenU2.entities.Usuario;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends ListCrudRepository<Usuario, Long> {

    // Forzamos la consulta SQL pura para evitar el error de las comillas dobles
    @Query("SELECT * FROM usuarios WHERE email = :email")
    Usuario findByEmail(@Param("email") String email);
}