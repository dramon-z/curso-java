drop table if exists asegurados;
drop table if exists direcciones;
CREATE TABLE direcciones (
	id INT(10) unsigned NOT NULL auto_increment,
	calle varchar(100),
	numero varchar(100),
	ciudad varchar(100),
	estado varchar(100),
	pais varchar(100),
	codigo_postal varchar(100),
	colonia varchar(100),
	PRIMARY KEY (id)
)ENGINE=INNODB;


create table asegurados(
	id int(10) unsigned not null auto_increment,
	nombre varchar(100),
	appat varchar(100),
	apmat varchar(100),
	folios varchar(100)unique,
	fecha_nacimiento date,
	sexo enum('Hombre','Mujer'),
	direccion_id int(10) unsigned NOT NULL,
	PRIMARY KEY(id),
	CONSTRAINT DIRECCION_FK
	FOREIGN KEY (direccion_id)
	REFERENCES direcciones (id)
	ON DELETE NO ACTION ON UPDATE NO ACTION
)ENGINE=INNODB;


