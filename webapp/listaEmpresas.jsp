<%@page import="gerenciador.servlet.Empresa"%>
<%@page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<html>
	<body>
		<c:if test="${not empty nomeEmpresa}">
			Nova empresa ${ nomeEmpresa } cadastrada com sucesso!
			<br/>
			<br/>
		</c:if>
		Lista de empresas: <br />
		<ul>
			<c:forEach items="${listaEmpresas}" var = "empresa">
				<li>${empresa.nome} - <fmt:formatDate value="${empresa.dataAbertura}" pattern="dd/MM/yyyy"/></li>
				<a href="/gerenciador/removeEmpresa?id=${empresa.id}">Remover</a>
			</c:forEach>
		</ul>
	</body>
</html>