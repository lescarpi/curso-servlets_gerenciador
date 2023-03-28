package gerenciador.servlet;

import java.io.IOException;

import gerenciador.acao.Acao;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ControladorFilter implements Filter {

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {

		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;

		String paramAcao = request.getParameter("acao");
		String nome;
		try {
			Acao acao = (Acao) Class.forName("gerenciador.acao." + paramAcao).newInstance();
			nome = acao.executa(request, response);
		} catch (Exception ex) {
			throw new ServletException(ex);
		}

		String type = nome.split(":")[0];
		nome = nome.split(":")[1];
		if (type.equals("forward")) {
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/" + nome);
			rd.forward(request, response);
		} else if (type.equals("redirect")) {
			response.sendRedirect(nome);
		}
		
	}

}
