package br.com.alura.gerenciador.servlet;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class Banco {

	static private List<Empresa> listaEmpresas = new ArrayList<Empresa>();

	private static Integer chaveSequencial = 1;

	static {
		Empresa empresa1 = new Empresa("Alura", new Date());
		Empresa empresa2 = new Empresa("Caelum", new Date());
		empresa1.setId(Banco.chaveSequencial++);
		Banco.listaEmpresas.add(empresa1);
		empresa2.setId(Banco.chaveSequencial++);
		Banco.listaEmpresas.add(empresa2);
	}

	public List<Empresa> getEmpresas() {
		return Banco.listaEmpresas;
	}

	public void adicionar(Empresa empresa) {
		empresa.setId(Banco.chaveSequencial++);
		Banco.listaEmpresas.add(empresa);
	}
	
	public Empresa getEmpresaById(Integer id) {
		List<Empresa> empresas = Banco.listaEmpresas.stream()
				.filter(e -> e.getId().equals(id))
				.limit(1)
				.collect(Collectors.toList());
		return empresas.get(0);
	}

	public void remover(Integer id) {
		Banco.listaEmpresas.remove(this.getEmpresaById(id));
	}
}
