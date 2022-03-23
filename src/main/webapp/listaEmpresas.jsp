<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="br.com.alura.gerenciador.servlet.Empresa, java.util.List" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Lista de Empresas: </h1>
	<ul>
	
	<%
		List<Empresa> listaEmpresas = (List<Empresa>)request.getAttribute("listaEmpresas");
		
		for (Empresa empresa : listaEmpresas) {
	%>
		<li><%= empresa.getNome() %></li>
	<%		 
			}
	%>
	</ul> 
</body>
</html>