<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<c:url value="/empresa" var="urlEmpresa"/>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Nova Empresa</title>
	</head>
	<body>
		<h4> [<a href="${ urlEmpresa }">Home</a>] </h4>
		<form action="${ urlEmpresa }" method="post">
			Nome: <input type="text" name="nome"/>
			Data Abertura: <input type="text" name="dataAbertura"/>
			<input type="hidden" name="acao" value="/cadastrarEmpresa"/>
			<input type="submit"/>
		</form>
	</body>
</html>