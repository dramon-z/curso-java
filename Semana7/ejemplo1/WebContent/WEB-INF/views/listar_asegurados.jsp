<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Lista de Asegurados</title>
</head>
<body>
	<h1>Lista de Asegurados</h1>
	<table border="1">
		<thead>
			<tr>
				<td>Nombre del Asegurado</td>
				<td>Edad</td>
				<td>Sexo</td>
				<td>Número de Seguro Social</td>
				<td>Opciones</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${asegurados}" var="asegurado">
			<tr>
				<td>${asegurado.getNombre()} ${asegurado.getApellido()}</td>
				<td>${asegurado.getEdad()}</td>
				<td>${asegurado.getSexo()}</td>
				<td>${asegurado.getNumeroSeguroSocial()}</td>
				<td>
					<a href="<c:url value="/detalle-asegurado?id=${asegurado.getId()}" />">Detalles</a>
				</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
	<a href="<c:url value="/agregar-asegurado" />">Agregar Asegurado</a>
</body>
</html>