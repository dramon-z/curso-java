drop view if exists vw_asegurados;

create view vw_asegurados as
select
	DATE_FORMAT(CURDATE(),'%m-%d') actual,
    DATE_FORMAT(`fecha_nacimiento`,'%m-%d') naci,
	asegurados.id, 
    concat(nombre, ' ',  apellido_paterno, ' ',  apellido_materno) as nombre_completo,
    folio, 
    timestampdiff(YEAR, fecha_nacimiento, curdate()) as edad,
    YEAR(fecha_nacimiento) - (YEAR(fecha_nacimiento) % 10) as decada, 
    sexo,
    calle, numero, ciudad, estado, pais
 from asegurados
	left join direcciones on (
    direcciones.id = asegurados.direccion_id);
    