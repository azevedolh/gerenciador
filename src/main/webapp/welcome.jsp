<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/listaEmpresas" var="urlListaEmpresas"/>
<c:url value="/formNovaEmpresa.jsp" var="urlNovaEmpresa"/>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Hello World!</title>
	</head>
	<body>
		<h1>Welcome to a simple servlet implementation.</h1>
		<h2>Select one of the options below:</h2> 
		<ul>
			<li><a href="${ urlNovaEmpresa }">Cadastrar Nova Empresa</a></li>
			<li><a href="${ urlListaEmpresas }">Listar empresas</a></li>
		</ul> 
	</body>
</html>