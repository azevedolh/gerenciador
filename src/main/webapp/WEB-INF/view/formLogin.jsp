<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<c:url value="/empresa" var="urlEmpresa"/>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Login</title>
	</head>
	<body>
		<h4> [<a href="${ urlEmpresa }">Home</a>] </h4>
		<form action="${ urlEmpresa }" method="post">
			Login: <input type="text" name="login"/>
			Senha: <input type="password" name="senha"/>
			<input type="hidden" name="acao" value="Login"/>
			<input type="submit"/>
		</form>
	</body>
</html>