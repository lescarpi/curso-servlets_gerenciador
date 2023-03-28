package gerenciador.servlet;

import java.io.IOException;

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
		
		String nome = null;
		if (paramAcao.equals("NovaEmpresa")) {
			NovaEmpresa acao = new NovaEmpresa();
			nome = acao.executa(request, response);
		} else if (paramAcao.equals("ListaEmpresas")) {
			ListaEmpresas acao = new ListaEmpresas();
			nome = acao.executa(request, response);
		} else if (paramAcao.equals("MostraEmpresa")) {
			MostraEmpresa acao = new MostraEmpresa();
			nome = acao.executa(request, response);
		} else if (paramAcao.equals("RemoveEmpresa")) {
			RemoveEmpresa acao = new RemoveEmpresa();
			nome = acao.executa(request, response);
		} else if (paramAcao.equals("EditaEmpresa")) {
			EditaEmpresa acao = new EditaEmpresa();
			nome = acao.executa(request, response);
		} else if (paramAcao.equals("NovaEmpresaForm")) {
			NovaEmpresaForm acao = new NovaEmpresaForm();
			nome = acao.executa(request, response);
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
