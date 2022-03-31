<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="br.com.alura.gerenciador.modelo.Empresa, java.util.List" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:url value="/empresa" var="home" />

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Empresas</title>
</head>
<body>

	<h4> [<a href="${ home }">Home</a>] </h4>

	<c:if test="${ not empty nomeEmpresa and not empty dataAbertura }">
		<fmt:formatDate value="${ dataAbertura }" pattern="dd/MM/yyyy" var="dataFormatada"/>
		<h1> Nova empresa ${ nomeEmpresa } - ${ dataFormatada } cadastrada! </h1>	
	</c:if>
	
	<h1>Lista de Empresas: </h1>
	<ul>
		<c:forEach items="${ listaEmpresas }" var="empresa" >
			<fmt:formatDate value="${ empresa.dataAbertura }" var="dataFormatada" pattern="dd/MM/yyyy" />
			<li> 
				${ empresa.nome } - ${ dataFormatada } 
				<a href="empresa?acao=/editarEmpresa&id=${empresa.id}">Editar</a> 
				<a href="empresa?acao=/removerEmpresa&id=${empresa.id}">Remover</a> 
			</li>	
		</c:forEach>
	</ul>
</body>
</html>