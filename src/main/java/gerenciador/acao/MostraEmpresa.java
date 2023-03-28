package gerenciador.acao;

import java.io.IOException;

import gerenciador.modelo.Banco;
import gerenciador.modelo.Empresa;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class MostraEmpresa implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
Integer idEmpresa = Integer.valueOf(request.getParameter("id"));
		
		Banco banco = new Banco();
		Empresa empresa = banco.buscaEmpresaPeloId(idEmpresa);
		
		request.setAttribute("empresa", empresa);
		
		return "forward:formEditaEmpresa.jsp";
		
	}
	
}
