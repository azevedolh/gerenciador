package br.com.alura.gerenciador.service;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.modelo.Banco;
import br.com.alura.gerenciador.modelo.Empresa;

public class EditarEmpresaService {
	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer id = Integer.valueOf(request.getParameter("id"));
		
		Banco banco = new Banco();
		Empresa empresa = banco.getEmpresaById(id);
		
		System.out.println("Editando empresa " + empresa.getNome());
		
		request.setAttribute("empresa", empresa);
		
		return "foward:formAlteraEmpresa.jsp";
	}
}
