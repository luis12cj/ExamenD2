-- Borramos la tabla si existe para crearla limpia
DROP TABLE IF EXISTS usuarios;

-- La creamos con el nombre exacto que busca Java
CREATE TABLE usuarios (
                          id BIGINT AUTO_INCREMENT PRIMARY KEY,
                          nombre VARCHAR(100) NOT NULL,
                          email VARCHAR(100) NOT NULL UNIQUE,
                          password VARCHAR(255) NOT NULL
);