<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Asegurados</title>
</head>
<body>
	<h1>Asegurados Registrados</h1>
	<table border="1">
		<tr>
			<td>Id</td>
			<td>Nombre</td>
			<td>Número del Seguro Social</td>
		</tr>
		<c:forEach items="${asegurados}" var="asegurado">
		<tr>
			<td>${asegurado.getId()}</td>
			<td>${asegurado.getNombre()} ${asegurado.getApellido()}</td>
			<td>${asegurado.getNumeroSeguroSocial()}</td>
			<c:url value="/asegurados/${asegurado.getId()}" var="detailsUrl" />
			<td><a href="${detailsUrl}">Detalles</a></td>
		</tr>
		</c:forEach>
	</table>
	<c:url value="/asegurados/nuevo" var="newUrl" />
	<a href="${newUrl}">Agregar Nuevo Asegurado</a>
</body>
</html>