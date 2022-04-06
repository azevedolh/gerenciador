package br.com.alura.gerenciador.acao;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.modelo.Banco;
import br.com.alura.gerenciador.modelo.Empresa;

public class ListaEmpresas implements Acao {
	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Listando empresas ");
		
		Banco banco = new Banco();
		List<Empresa> ListaEmpresas = banco.getEmpresas();
		
		request.setAttribute("ListaEmpresas", ListaEmpresas);
		
		return "foward:listaEmpresas.jsp";
	}
}
