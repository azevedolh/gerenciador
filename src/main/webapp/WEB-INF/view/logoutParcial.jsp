<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/empresa?acao=Logout" var="logout" />

<c:if test="${ not empty usuarioLogado }">
		<a href="${ logout }">Logout</a>
		<br>
</c:if>