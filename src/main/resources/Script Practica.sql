drop schema if exists práctica;
drop user if exists usuario_practica;

Create schema práctica;
create user 'usuario_practica'@'%'  identified by 'la_Clave';
grant all privileges on  práctica.* TO 'usuario_practica';

flush privileges;


CREATE TABLE práctica.arbol (
  id INT AUTO_INCREMENT PRIMARY KEY,
  ruta_imagen TEXT,
  nombre_comun VARCHAR(100),
  tipo_flor VARCHAR(100),
  dureza_madera INT,
  otro_campo TEXT
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;