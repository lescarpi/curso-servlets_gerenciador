package gerenciador.acao;

import java.io.IOException;

import gerenciador.modelo.Banco;
import gerenciador.modelo.Usuario;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class Login implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		Banco banco = new Banco();
		Usuario usuario = banco.usuarioExiste(request.getParameter("login"), request.getParameter("senha"));
		
		if (usuario != null) {
			HttpSession sessao = request.getSession();
			sessao.setAttribute("usuarioLogado", usuario);
			return "redirect:entrada?acao=ListaEmpresas";
		} else {
			return "redirect:entrada?acao=LoginForm";
		}
		
	}

}
