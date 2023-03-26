package gerenciador.servlet;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/mostraEmpresa")
public class MostraEmpresaServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Integer idEmpresa = Integer.valueOf(request.getParameter("id"));
		
		Banco banco = new Banco();
		Empresa empresa = banco.buscaEmpresaPeloId(idEmpresa);
		
		request.setAttribute("empresa", empresa);
		
		RequestDispatcher rd = request.getRequestDispatcher("/formEditaEmpresa.jsp");
		rd.forward(request, response);
		
	}

}
