<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:url value="/empresa" var="urlEmpresa"/>
<c:url value="/empresa?acao=/listaEmpresas" var="listaEmpresas"/>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Alterar Empresa</title>
	</head>
	<body>
		<h4> [<a href="${ urlEmpresa }">Home</a>] </h4> 
		<form action="${ urlEmpresa }" method="post">
			<fmt:formatDate value="${ empresa.dataAbertura }" var="dataFormatada" pattern="dd/MM/yyyy" />
			Nome: <input type="text" name="nome" value="${ empresa.nome }"/>
			Data Abertura: <input type="text" name="dataAbertura" value="${ dataFormatada }"/>
			<input type="hidden" name="id" value="${ empresa.id }"/>
			<input type="hidden" name="acao" value="/alterarEmpresa"/>
			<input type="submit" />
		</form>
		<h4> [<a href="${ listaEmpresas }">Voltar</a>] </h4>
	</body>
</html>