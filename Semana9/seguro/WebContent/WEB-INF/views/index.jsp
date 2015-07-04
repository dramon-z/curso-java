<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Control de Asegurados</title>
</head>
<body>
	<c:url value="/logout" var="logoutUrl" />
	<form action="${logoutUrl}" method="post">
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
		<button type="submit">Cerrar Sesión</button>
	</form>
	<h1>¡Bienvenido a la aplicación de control de asegurados!</h1>
	<c:url value="/" var="rootUrl" />
	<ul>
		<li>
			<a href="${rootUrl}/asegurados/">Asegurados</a>
		</li>
		<li>
			<a href="${rootUrl}/consultas/">Consultas</a>
		</li>
		<li>
			<a href="${rootUrl}/medicamentos/">Medicamentos</a>
		</li>
		<li>
			<a href="${rootUrl}/medicos/">Médicos</a>
		</li>
		<li>
			<a href="${rootUrl}/recetas/">Recetas</a>
		</li>
		<li>
			<a href="${rootUrl}/usuarios/">Usuarios</a>
		</li>
	</ul>
</body>
</html>