<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Agregar Asegurado</title>
</head>
<body>
	<h1>Agregar Asegurado</h1>
	<c:url value="/asegurados/guardar" var="saveUrl" />
	<form action="${saveUrl}"  method="post">
		<table>
			<tr>
				<td><label for="nombre">Nombre:</label></td>
				<td><input name="nombre" type="text" value="${asegurado.getNombre()}" /></td>
			</tr>
			<tr>
				<td><label for="apellido">Apellido:</label></td>
				<td><input name="apellido" type="text" value="${asegurado.getApellido()}" /></td>
			</tr>
			<tr>
				<td><label for="edad">Edad:</label></td>
				<td><input name="edad" type="text" value="${asegurado.getEdad()}" /></td>
			</tr>
			<tr>
				<td><label for="sexo">Sexo:</label></td>
				<td>
					<select name="sexo">
						<option>-- Seleccione una opción --</option>
						<option value="M" ${'M'.equals(asegurado.getSexo()) ? 'selected' : ''}>Masculino</option>
						<option value="F" ${'F'.equals(asegurado.getSexo()) ? 'selected' : ''}>Femenino</option>
					</select>
				</td>
			</tr>
			<tr>
				<td><label for="numeroSeguroSocial">Número de Seguro Social:</label></td>
				<td><input name="numeroSeguroSocial" type="text" value="${asegurado.getNumeroSeguroSocial()}" /></td>
			</tr>
			<tr>
				<td></td>
				<td><button type="submit">Guardar</button></td>
			</tr>
		</table>
	</form>
</body>
</html>