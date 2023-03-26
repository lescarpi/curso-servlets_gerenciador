package gerenciador.servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/removeEmpresa")
public class RemoveEmpresaServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Integer idEmpresa = Integer.valueOf(request.getParameter("id"));
		
		Banco banco = new Banco();
		banco.removeEmpresa(idEmpresa);
		
		response.sendRedirect("/gerenciador/listaEmpresas");
		
	}

}
