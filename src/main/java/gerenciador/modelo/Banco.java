package gerenciador.modelo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Banco {

	private static List<Empresa> listaEmpresa = new ArrayList<>();
	private static List<Usuario> listaUsuario = new ArrayList<>();
	private static Integer chaveSequencial = 1;
	
	static {
		Empresa empresa1 = new Empresa();
		empresa1.setId(chaveSequencial++);
		empresa1.setNome("Gibson");
		Empresa empresa2 = new Empresa();
		empresa2.setId(chaveSequencial++);
		empresa2.setNome("Fender");
		listaEmpresa.add(empresa1);
		listaEmpresa.add(empresa2);
		
		Usuario usuario1 = new Usuario();
		usuario1.setLogin("lele");
		usuario1.setSenha("123");
		Usuario usuario2 = new Usuario();
		usuario2.setLogin("xuxa");
		usuario2.setSenha("543");
		listaUsuario.add(usuario1);
		listaUsuario.add(usuario2);
	}
	
	public void adicionaEmpresa(Empresa empresa) {
		empresa.setId(Banco.chaveSequencial++);
		listaEmpresa.add(empresa);
	}
	
	public void removeEmpresa(Integer id) {
		Iterator<Empresa> it = listaEmpresa.iterator();
		
		while(it.hasNext()) {
			Empresa empresa = it.next();
			
			if(empresa.getId() == id) {
				it.remove();
			}
		}
	}
	
	public Empresa buscaEmpresaPeloId(Integer id) {
		for(Empresa empresa : listaEmpresa) {
			if(empresa.getId() == id) {
				return empresa;
			}
		}
		return null;
	}
	
	public List<Empresa> getEmpresas() {
		return Banco.listaEmpresa;
	}
	
	public Usuario usuarioExiste(String login, String senha) {
		for(Usuario usuario : listaUsuario) {
			if (usuario.isEqual(login, senha)) {
				return usuario;
			}
		}
		return null;
	}
	
}
