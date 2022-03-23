package br.com.alura.gerenciador.servlet;

import java.util.ArrayList;
import java.util.List;

public class Banco {
	
	static private List<Empresa> listaEmpresas = new ArrayList<Empresa>();
	
	static {
		Empresa empresa1 = new Empresa("Alura");
		Empresa empresa2 = new Empresa("Caelum");
		Banco.listaEmpresas.add(empresa1);
		Banco.listaEmpresas.add(empresa2);
	}
	
	public List<Empresa> getEmpresas() {
		return Banco.listaEmpresas;
	}
	
	public void adicionar(Empresa empresa) {
		Banco.listaEmpresas.add(empresa);
	}

}
