package gerenciador.servlet;

import java.io.IOException;

import gerenciador.acao.Acao;
import gerenciador.acao.EditaEmpresa;
import gerenciador.acao.ListaEmpresas;
import gerenciador.acao.MostraEmpresa;
import gerenciador.acao.NovaEmpresa;
import gerenciador.acao.NovaEmpresaForm;
import gerenciador.acao.RemoveEmpresa;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/entrada")
public class UnicaEntradaServlet extends HttpServlet{
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String paramAcao = request.getParameter("acao");
		
		String nome;
		try {
			Acao acao = (Acao)Class.forName("gerenciador.acao."+paramAcao).newInstance();
			nome = acao.executa(request, response);
		} catch (Exception ex) {
			throw new ServletException(ex);
		}

		String type = nome.split(":")[0];
		nome = nome.split(":")[1];
		if(type.equals("forward")) {
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/"+nome);
			rd.forward(request, response);
		} else if (type.equals("redirect")) {
			response.sendRedirect(nome);
		}
		
	}
	
}
