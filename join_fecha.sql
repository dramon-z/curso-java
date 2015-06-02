select 
	asegurados.id,
	concat(nombre,' ',appat,' ',apmat) as nombre_completo,
folios,fecha_nacimiento,sexo,calle,numero,ciudad,estado,pais
from asegurados
	left join direcciones on (
direcciones.id = asegurados.direccion_id);


CREATE view vw_asegurados as
select 
#	date_format(curdate(),'%m-%d') actual,
#	date_format(fecha_nacimiento,'%m-%d') naci,
	asegurados.id,
	concat(nombre,' ',appat,' ',apmat) as nombre_completo,
	folios,
#	YEAR (now()) - year(fecha_nacimiento)+
#	if (date_format(curdate(),'%m-%d') > date_format(fecha_nacimiento,'%m-%d'), 0, -1)
#	as edad1,
	timestampdiff(year,fecha_nacimiento, curdate()) as edad2,
	year(fecha_nacimiento) - (year(fecha_nacimiento) % 10) as decada,
	fecha_nacimiento,sexo,calle,numero,ciudad,estado,pais
from asegurados
	left join direcciones on (
	direcciones.id = asegurados.direccion_id);

select * from vw_asegurados;
