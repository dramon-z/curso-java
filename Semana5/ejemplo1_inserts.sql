
truncate table asegurados;

delete from direcciones where id > 0;

INSERT INTO `direcciones`
(`id`,`Calle`,`numero`,`ciudad`,`estado`,`pais`,`codigo_postal`,`colonia`)
VALUES
(1,'Calle1','128 Altos','Villahermosa','Tabasco','México','86080','Reforma');

INSERT INTO `asegurados`
(`id`,`nombre`,`apellido_paterno`,`apellido_materno`,`folio`,`fecha_nacimiento`,`sexo`,`direccion_id`)
VALUES
(1,'Persona1','Seoane','García','1000','1981-11-25','Hombre',1);



INSERT INTO `direcciones`
(`id`,`Calle`,`numero`,`ciudad`,`estado`,`pais`,`codigo_postal`,`colonia`)
VALUES
(2,'Calle1','128 Altos','Villahermosa','Tabasco','México','86080','Reforma');

INSERT INTO `asegurados`
(`id`,`nombre`,`apellido_paterno`,`apellido_materno`,`folio`,`fecha_nacimiento`,`sexo`,`direccion_id`)
VALUES
(2,'Persona2','Seoane','García','1001','1982-11-25','Mujer',2);




INSERT INTO `direcciones`
(`id`,`Calle`,`numero`,`ciudad`,`estado`,`pais`,`codigo_postal`,`colonia`)
VALUES
(3,'Calle1','128 Altos','Villahermosa','Tabasco','México','86080','Reforma');

INSERT INTO `asegurados`
(`id`,`nombre`,`apellido_paterno`,`apellido_materno`,`folio`,`fecha_nacimiento`,`sexo`,`direccion_id`)
VALUES
(3,'Persona3','Seoane','García','1002','1983-11-25','Hombre',3);






INSERT INTO `direcciones`
(`id`,`Calle`,`numero`,`ciudad`,`estado`,`pais`,`codigo_postal`,`colonia`)
VALUES
(4,'Calle1','128 Altos','Villahermosa','Tabasco','México','86080','Reforma');

INSERT INTO `asegurados`
(`id`,`nombre`,`apellido_paterno`,`apellido_materno`,`folio`,`fecha_nacimiento`,`sexo`,`direccion_id`)
VALUES
(4,'Persona4','Seoane','García','1003','1984-11-25','Mujer',4);








INSERT INTO `direcciones`
(`id`,`Calle`,`numero`,`ciudad`,`estado`,`pais`,`codigo_postal`,`colonia`)
VALUES
(5,'Calle1','128 Altos','Teapa','Tabasco','México','86080','Reforma');

INSERT INTO `asegurados`
(`id`,`nombre`,`apellido_paterno`,`apellido_materno`,`folio`,`fecha_nacimiento`,`sexo`,`direccion_id`)
VALUES
(5, 'Persona5','Seoane','García','1004','1985-11-25','Hombre',5);










INSERT INTO `direcciones`
(`id`,`Calle`,`numero`,`ciudad`,`estado`,`pais`,`codigo_postal`,`colonia`)
VALUES
(6,'Calle1','128 Altos','Villahermosa','Tabasco','México','86080','Reforma');

INSERT INTO  `asegurados`
(`id`,`nombre`,`apellido_paterno`,`apellido_materno`,`folio`,`fecha_nacimiento`,`sexo`,`direccion_id`)
VALUES
(6,'Persona6','Seoane','García','1005','1986-11-25','Hombre',6);





INSERT INTO `direcciones`
(`id`,`Calle`,`numero`,`ciudad`,`estado`,`pais`,`codigo_postal`,`colonia`)
VALUES
(7,'Calle1','128 Altos','Teapa','Tabasco','México','86080','Reforma');

INSERT INTO `asegurados`
(`id`,`nombre`,`apellido_paterno`,`apellido_materno`,`folio`,`fecha_nacimiento`,`sexo`,`direccion_id`)
VALUES
(7,'Persona7','Seoane','García','1006','1987-11-25','Hombre',7);






INSERT INTO `direcciones`
(`id`,`Calle`,`numero`,`ciudad`,`estado`,`pais`,`codigo_postal`,`colonia`)
VALUES
(8,'Calle1','128 Altos','Cardenas','Tabasco','México','86080','Reforma');

INSERT INTO `asegurados`
(`id`,`nombre`,`apellido_paterno`,`apellido_materno`,`folio`,`fecha_nacimiento`,`sexo`,`direccion_id`)
VALUES
(8,'Persona8','Seoane','García','1007','1988-11-25','Hombre',8);








INSERT INTO `direcciones`
(`id`,`Calle`,`numero`,`ciudad`,`estado`,`pais`,`codigo_postal`,`colonia`)
VALUES
(9,'Calle1','128 Altos','Villahermosa','Tabasco','México','86080','Reforma');

INSERT INTO `asegurados`
(`id`,`nombre`,`apellido_paterno`,`apellido_materno`,`folio`,`fecha_nacimiento`,`sexo`,`direccion_id`)
VALUES
(9,'Persona9','Seoane','García','1008','1989-11-25','Mujer',9);








INSERT INTO `direcciones`
(`id`,`Calle`,`numero`,`ciudad`,`estado`,`pais`,`codigo_postal`,`colonia`)
VALUES
(10,'Calle1','128 Altos','Cardenas','Tabasco','México','86080','Reforma');

INSERT INTO `asegurados`
(`id`,`nombre`,`apellido_paterno`,`apellido_materno`,`folio`,`fecha_nacimiento`,`sexo`,`direccion_id`)
VALUES
(10,'Persona10','Seoane','García','1009','1990-11-25','Hombre',10);
