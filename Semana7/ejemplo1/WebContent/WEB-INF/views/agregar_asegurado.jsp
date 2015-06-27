<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Agregar Nuevo Asegurado</title>
</head>
<body>
	<h1>Agregar Nuevo Asegurado</h1>
	<form action="" method="post">
		<table border="1">
			<tr>
				<td><label for="nombre">Nombre:</label></td>
				<td><input type="text" name="nombre" /></td>
			</tr>
			<tr>
				<td><label for="apellido">Apellido:</label></td>
				<td><input type="text" name="apellido" /></td>
			</tr>
			<tr>
				<td><label for="edad">Edad:</label></td>
				<td><input type="text" name="edad" /></td>
			</tr>
			<tr>
				<td><label for="sexo">Sexo:</label></td>
				<td><select name="sexo">
						<option value="M">Masculino</option>
						<option value="F">Femenino</option>
				</select></td>
			</tr>
			<tr>
				<td><label for="numero_seguro_social">Número del Seguro
						Social</label></td>
				<td><input type="text" name="numero_seguro_social" /></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Guardar Asegurado" /></td>
			</tr>
		</table>
	</form>
</body>
</html>