use curso_java;

drop table if exists asegurados;
drop table if exists direcciones;

CREATE TABLE direcciones (
	id INT(10) unsigned NOT NULL AUTO_INCREMENT,
	Calle varchar(100),
	numero varchar(100),
	ciudad varchar(100),
	estado varchar(100),
	pais varchar(100),
	codigo_postal varchar(100),
	colonia varchar(100),
	PRIMARY KEY (id)
)ENGINE=INNODB;

CREATE TABLE asegurados (
	id	INT(10) unsigned NOT NULL AUTO_INCREMENT,
	nombre varchar(100),
	apellido_paterno varchar(100),
	apellido_materno varchar(100),
	folio varchar(100) unique,
	fecha_nacimiento date,
	sexo ENUM('Hombre','Mujer'),
	direccion_id INT(10) unsigned NOT NULL,
	PRIMARY KEY (id),
	CONSTRAINT DIRECCION_FK 
	FOREIGN KEY (direccion_id) 
    REFERENCES direcciones (id) 
    ON DELETE NO ACTION ON UPDATE NO ACTION
)ENGINE=INNODB;












