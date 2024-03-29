package gerenciador.acao;

import java.io.IOException;
import java.util.List;

import gerenciador.modelo.Banco;
import gerenciador.modelo.Empresa;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class ListaEmpresas implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		HttpSession sessao = request.getSession();
		if (sessao.getAttribute("usuarioLogado") == null) {
			return "redirect:entrada?acao=LoginForm";
		}
		
		Banco banco = new Banco();
		List<Empresa> lista = banco.getEmpresas();
	
		request.setAttribute("listaEmpresas", lista);
		
		return "forward:listaEmpresas.jsp";

	}
	
}
