<%@page import="gerenciador.modelo.Empresa"%>
<%@page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<html>
<body>
	<a href="entrada?acao=Logout">Sair</a>
	<br />
	<br /> Usuario logado: ${usuarioLogado.login}
	<br />
	<br /> Lista de empresas:
	<br />
	<ul>
		<c:forEach items="${listaEmpresas}" var="empresa">
			<li>${empresa.nome}- <fmt:formatDate
					value="${empresa.dataAbertura}" pattern="dd/MM/yyyy" /></li>
			<a href="/gerenciador/entrada?acao=MostraEmpresa&id=${empresa.id}">Editar</a>
			<a href="/gerenciador/entrada?acao=RemoveEmpresa&id=${empresa.id}">Remover</a>
		</c:forEach>
	</ul>
</body>
</html>