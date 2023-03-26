<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
	<body>
		<c:if test="${not empty nomeEmpresa}">
			Nova empresa ${ nomeEmpresa } cadastrada com sucesso!
		</c:if>
		<c:if test="${empty nomeEmpresa}">
			Nenhuma empresa cadastrada!
		</c:if>
	</body>
</html>