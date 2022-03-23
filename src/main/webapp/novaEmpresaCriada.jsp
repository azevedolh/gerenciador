<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>  

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Empresa</title>
</head>
<body>
	<c:if test="${ not empty nomeEmpresa and not empty dataAbertura }">
		<fmt:formatDate value="${ dataAbertura }" pattern="dd/MM/yyyy" var="dataFormatada"/>
		<h1> Nova empresa ${ nomeEmpresa } - ${ dataFormatada } cadastrada! </h1>	
	</c:if>
	
	<c:if test="${ empty nomeEmpresa or empty dataAbertura }">
		<h1> Nenhuma empresa informada! </h1>	
	</c:if>

</body>
</html>