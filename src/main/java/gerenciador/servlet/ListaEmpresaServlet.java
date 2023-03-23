package gerenciador.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/listaEmpresas")
public class ListaEmpresaServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		PrintWriter out = resp.getWriter();
		
		Banco banco = new Banco();
		List<Empresa> lista = banco.getEmpresas();
		
		out.println("<html><body><ul>");
		lista.forEach(e -> 
				out.println("<li>" + e.getNome() + "</li>")
				);
		out.println("</ul></body></html>");
		
	}

}
