package br.com.alura.gerenciador.modelo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class Banco {

	static private List<Empresa> listaEmpresas = new ArrayList<Empresa>();
	static private List<Usuario> listaUsuarios = new ArrayList<Usuario>();

	private static Integer chaveSequencial = 1;

	static {
		Empresa empresa1 = new Empresa("Alura", new Date());
		Empresa empresa2 = new Empresa("Caelum", new Date());
		empresa1.setId(Banco.chaveSequencial++);
		Banco.listaEmpresas.add(empresa1);
		empresa2.setId(Banco.chaveSequencial++);
		Banco.listaEmpresas.add(empresa2);
		
		Usuario usuario1 = new Usuario("teste", "123");
		Banco.listaUsuarios.add(usuario1);
	}

	public List<Empresa> getEmpresas() {
		return Banco.listaEmpresas;
	}
	
	public List<Usuario> getUsuarios() {
		return Banco.listaUsuarios;
	}

	public void adicionar(Empresa empresa) {
		empresa.setId(Banco.chaveSequencial++);
		Banco.listaEmpresas.add(empresa);
	}
	
	public Empresa getEmpresaById(Integer id) {
		Empresa empresa = Banco.listaEmpresas.stream()
				.filter(e -> e.getId().equals(id))
				.findAny()
				.orElse(null);
		return empresa;
	}

	public void remover(Integer id) {
		Banco.listaEmpresas.remove(this.getEmpresaById(id));
	}
}
