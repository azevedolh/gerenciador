package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import java.util.Optional;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/novaEmpresa")
public class NovaEmpresaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Cadastrando nova empresa");
		Optional<String> nomeEmpresa = Optional.ofNullable(request.getParameter("nome"));
		
		Empresa empresa = new Empresa(nomeEmpresa.orElse("[nome não informado]"));
		Banco banco = new Banco();
		banco.adicionar(empresa);
		
		request.setAttribute("nomeEmpresa", empresa.getNome());
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/novaEmpresaCriada.jsp");
		dispatcher.forward(request, response);
	}

}
