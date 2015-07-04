<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Index Asegurados</h1>
	<table border="1">
		<tr>
			<td>Nómbre</td>
			<td>Edad</td>
			<td>Sexo</td>
			<td>Número del Seguro Social</td>
		</tr>
		<c:forEach items="${asegurados}" var="asegurado">
		<tr>
			<td>${asegurado.getNombre()} ${asegurado.getApellido()}</td>
			<td>${asegurado.getEdad()}</td>
			<td>${asegurado.getSexo()}</td>
			<td>${asegurado.getNumeroSeguroSocial()}</td>
			<td><a href="<c:url value="/asegurados/detalle?id=${asegurado.getId()}" />">Detalle</a></td>
		</tr>
		</c:forEach>
	</table>
	<a href="<c:url value="/asegurados/nuevo" />">Nuevo Asegurado</a>
</body>
</html>