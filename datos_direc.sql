truncate table asegurados;
delete from direcciones where id > 0;

insert into direcciones
	(id,calle,numero,ciudad,estado,pais,codigo_postal,colonia)
	values
	(1,'calle11','12','Teapa','Tabasco','Mexico','86800','Centro');

insert into direcciones
	(id,calle,numero,ciudad,estado,pais,codigo_postal,colonia)
	values
	(2,'calle1','1256','Tacotalpa','Tabasco','Mexico','85540','Centro');

insert into direcciones
	(id,calle,numero,ciudad,estado,pais,codigo_postal,colonia)
	values
	(3,'calle235','1658','Teapa','Tabasco','Mexico','86800','Centro');

insert into direcciones
	(id,calle,numero,ciudad,estado,pais,codigo_postal,colonia)
	values
	(4,'calle1','30','Teapa','Tabasco','Mexico','86800','Centro');

insert into direcciones
	(id,calle,numero,ciudad,estado,pais,codigo_postal,colonia)
	values
	(5,'calle878','9856','Jalapa','Tabasco','Mexico','86200','Centro');

insert into direcciones
	(id,calle,numero,ciudad,estado,pais,codigo_postal,colonia)
	values
	(6,'calle465','19612','Teapa','Tabasco','Mexico','81800','Centro');

insert into direcciones
	(id,calle,numero,ciudad,estado,pais,codigo_postal,colonia)
	values
	(7,'calle75','6587','Teapa','Tabasco','Mexico','81500','Centro');

insert into direcciones
	(id,calle,numero,ciudad,estado,pais,codigo_postal,colonia)
	values
	(8,'calle74','45876','Teapa','Tabasco','Mexico','82100','Centro');

insert into direcciones
	(id,calle,numero,ciudad,estado,pais,codigo_postal,colonia)
	values
	(9,'calle521','357','Teapa','Tabasco','Mexico','86800','Centro');

insert into direcciones
	(id,calle,numero,ciudad,estado,pais,codigo_postal,colonia)
	values
	(10,'calle74123','46135','Teapa','Tabasco','Mexico','81100','Centro');

insert into asegurados
	(id,nombre,appat,apmat,folios,fecha_nacimiento,sexo,direccion_id)
	values
	(1,'Antonio','Aguilar','Estrada','821221','1982-12-21','Hombre',1);

	insert into asegurados
	(id,nombre,appat,apmat,folios,fecha_nacimiento,sexo,direccion_id)
	values
	(2,'Pedro','Aguilar','Estrada','780131','1978-01-31','Hombre',2);

	insert into asegurados
	(id,nombre,appat,apmat,folios,fecha_nacimiento,sexo,direccion_id)
	values
	(3,'Lorena','Aguilar','Estrada','841111','1982-12-21','Mujer',3);

	insert into asegurados
	(id,nombre,appat,apmat,folios,fecha_nacimiento,sexo,direccion_id)
	values
	(4,'Jesus David','Aguilar','Estrada','461216185','2000-12-24','Hombre',4);

	insert into asegurados
	(id,nombre,appat,apmat,folios,fecha_nacimiento,sexo,direccion_id)
	values
	(5,'Francisco','andino','Spsche','82v1221','1975-12-05','Mujer',5);

	insert into asegurados
	(id,nombre,appat,apmat,folios,fecha_nacimiento,sexo,direccion_id)
	values
	(6,'Antonio','Mendez','Mayo','821','1982-12-21','Hombre',6);

	insert into asegurados
	(id,nombre,appat,apmat,folios,fecha_nacimiento,sexo,direccion_id)
	values
	(7,'Marco Antonio','Mena','Garcia','684634','1988-12-01','Hombre',7);

	insert into asegurados
	(id,nombre,appat,apmat,folios,fecha_nacimiento,sexo,direccion_id)
	values
	(8,'Samuel','Guillen','Estrada','654164','1962-11-21','Hombre',8);

	insert into asegurados
	(id,nombre,appat,apmat,folios,fecha_nacimiento,sexo,direccion_id)
	values
	(9,'Lucia','Perez','Rommel','6646841','1982-12-21','Mujer',9);

	insert into asegurados
	(id,nombre,appat,apmat,folios,fecha_nacimiento,sexo,direccion_id)
	values
	(10,'Rosa','Estrada','Amaya','65498001098','1985-12-25-','Mujer',10);