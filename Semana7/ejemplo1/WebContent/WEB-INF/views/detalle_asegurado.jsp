<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Detalles del Asegurado</title>
</head>
<body>
	<h1>Detalles del Asegurado</h1>
	<table border="1">
		<tr>
			<td>Nombre:</td>
			<td>${asegurado.getNombre()} ${asegurado.getApellido()}</td>
		</tr>
		<tr>
			<td>Edad:</td>
			<td>${asegurado.getEdad()}</td>
		</tr>
		<tr>
			<td>Sexo:</td>
			<td>${asegurado.getSexo()}</td>
		</tr>
		<tr>
			<td>Número de Seguro Social</td>
			<td>${asegurado.getNumeroSeguroSocial()}</td>
		</tr>
	</table>
	<a href="<c:url value="/" />">Volver al Inicio</a>
</body>
</html>