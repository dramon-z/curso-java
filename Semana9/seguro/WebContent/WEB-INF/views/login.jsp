<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
</head>
<body>
	<c:url value="/login" var="loginUrl" />
	<form action="${loginUrl}" method="post">
		<c:if test="${param.error != null}">
			<p>Usuario / Contraseña no válidos</p>
		</c:if>
		<table>
			<tr>
				<td><label>Usuario:</label></td>
				<td><input type="text" name="username" /></td>
			</tr>
			<tr>
				<td><label>Contraseña:</label></td>
				<td><input type="password" name="password" /></td>
			</tr>
			<tr>
				<td>
					<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
					<button type="submit">Acceder</button>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>