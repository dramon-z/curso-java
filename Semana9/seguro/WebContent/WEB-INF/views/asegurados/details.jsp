<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Detalle de Asegurado</title>
</head>
<body>
	<h1>Detalles del Asegurado</h1>
	<table>
		<tr>
			<td>Id:</td>
			<td>${asegurado.getId()}</td>
		</tr>
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
			<td>${asegurado.getSexo().equals('M') ? 'Masculino' : 'Femenino'}</td>
		</tr>
		<tr>
			<td>Número de Seguro Social:</td>
			<td>${asegurado.getNumeroSeguroSocial()}</td>
		</tr>
	</table>
	<c:url value="/asegurados/" var="urlBack" />
	<a href="${urlBack}">Regresar</a>
</body>
</html>