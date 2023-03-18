package gerenciador.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/novaEmpresa")
public class NovaEmpresaServlet extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
		System.out.println("Nova empresa");
		String nomeEmpresa = request.getParameter("nome");
		PrintWriter out = response.getWriter();
		out.println("<html><body>Nova empresa " + nomeEmpresa + " cadastrada com sucesso!</body></html>");
	}

}
