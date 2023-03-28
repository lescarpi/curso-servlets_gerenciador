package gerenciador.acao;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class NovaEmpresaForm {
	
	public String executa(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		return "forward:formNovaEmpresa.jsp";
		
	}

}
