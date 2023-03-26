<%@page import="gerenciador.servlet.Empresa"%>
<%@page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
	<body>
		Lista de empresas: <br />
		<ul>
			<c:forEach items="${listaEmpresas}" var = "empresa">
				<li>${empresa.nome}</li>
			</c:forEach>
		</ul>
	</body>
</html>