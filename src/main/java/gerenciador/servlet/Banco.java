package gerenciador.servlet;

import java.util.ArrayList;
import java.util.List;

public class Banco {

	private static List<Empresa> lista = new ArrayList<>();
	
	static {
		Empresa empresa1 = new Empresa();
		empresa1.setNome("Gibson");
		Empresa empresa2 = new Empresa();
		empresa2.setNome("Fender");
		lista.add(empresa1);
		lista.add(empresa2);
	}
	
	public void adicionaEmpresa(Empresa empresa) {
		lista.add(empresa);
	}
	
	public List<Empresa> getEmpresas() {
		return Banco.lista;
	}
	
}
