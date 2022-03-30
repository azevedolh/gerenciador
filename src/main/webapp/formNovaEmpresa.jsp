<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<c:url value="/novaEmpresa" var="urlNovaEmpresaServlet"/>
<c:url value="/welcome.jsp" var="home"/>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Nova Empresa</title>
	</head>
	<body>
		<h4> [<a href="${ home }">Home</a>] </h4>
		<form action="${ urlNovaEmpresaServlet }" method="post">
			Nome: <input type="text" name="nome"/>
			Data Abertura: <input type="text" name="dataAbertura"/>
			<input type="submit"/>
		</form>
	</body>
</html>