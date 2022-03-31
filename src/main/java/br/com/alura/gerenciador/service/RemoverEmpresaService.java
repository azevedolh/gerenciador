package br.com.alura.gerenciador.service;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.modelo.Banco;

public class RemoverEmpresaService {
	public String executa(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Integer id = Integer.valueOf(request.getParameter("id"));
		
		System.out.println("Removendo empresa com id " + id );
		
		Banco banco = new Banco();
		banco.remover(id);
		
		return "redirect:empresa?acao=/listaEmpresas";
	}
}
