package gerenciador.acao;

import java.io.IOException;
import java.util.List;

import gerenciador.modelo.Banco;
import gerenciador.modelo.Empresa;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ListaEmpresas {

	public String executa(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		Banco banco = new Banco();
		List<Empresa> lista = banco.getEmpresas();
	
		request.setAttribute("listaEmpresas", lista);
		
		return "forward:listaEmpresas.jsp";

	}
	
}
