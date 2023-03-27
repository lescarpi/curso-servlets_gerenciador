<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:url value="/entrada" var="linkServletEntrada"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="${linkServletEntrada}" method="post">

		Nome: <input type="text" name="nome" value="${empresa.nome}">
		Data: <input type="text" name="data" value="<fmt:formatDate value="${empresa.dataAbertura}" pattern="dd/MM/yyyy"/>">
		<input type="hidden" name="id" value="${empresa.id}"/>
		<input type="hidden" name="acao" value="EditaEmpresa"/>
		
		<input type="submit" value="Enviar"/>
	</form>

</body>
</html>