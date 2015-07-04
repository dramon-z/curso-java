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
	<form action="<c:url value="/asegurados/resultado" />" method ="post">
		<table>
			<tr>
				<td><label>Nombre:</label></td>
				<td><input type="text" name="nombre" /></td>
			</tr>
			<tr>
				<td><label>Apellido:</label></td>
				<td><input type="text" name="apellido" /></td>
			</tr>
			<tr>
				<td><label>Edad:</label></td>
				<td><input type="text" name="edad" /></td>
			</tr>
			<tr>
				<td><label>Sexo:</label></td>
				<td>
					<select name="sexo">
						<option value="M">Masculino</option>
						<option value="F">Femenino</option>
					</select>
				</td>
			</tr>
			<tr>
				<td><label>Número Seguro Social:</label></td>
				<td><input type="text" name="numeroSeguroSocial" /></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Enviar" /></td>
			</tr>
		</table>
	</form>
</body>
</html>