<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Detalle del Asegurado</title>
</head>
<body>
	<table>
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
			<td>Número del Seguro Social:</td>
			<td>${asegurado.getNumeroSeguroSocial()}</td>
		</tr>
	</table>
	<a href="<c:url value="/asegurados/" />">Regresar</a>
</body>
</html>