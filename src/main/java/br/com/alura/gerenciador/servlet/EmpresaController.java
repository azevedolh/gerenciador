package br.com.alura.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.service.AlterarEmpresaService;
import br.com.alura.gerenciador.service.CadastrarEmpresaService;
import br.com.alura.gerenciador.service.EditarEmpresaService;
import br.com.alura.gerenciador.service.EmpresaHomeService;
import br.com.alura.gerenciador.service.FormEmpresaService;
import br.com.alura.gerenciador.service.ListaEmpresaService;
import br.com.alura.gerenciador.service.RemoverEmpresaService;

@WebServlet("/empresa")
public class EmpresaController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String acao = request.getParameter("acao");
		
		String link = null;
		
		if (acao == null) {
			EmpresaHomeService empresaHome = new EmpresaHomeService();
			link = empresaHome.executa(request, response);
		} else if (acao.equals("/listaEmpresas")) {
			ListaEmpresaService listaEmpresa = new ListaEmpresaService();
			link = listaEmpresa.executa(request, response);
		} else if (acao.equals("/cadastrarEmpresa")) {
			CadastrarEmpresaService cadastrarEmpresa = new CadastrarEmpresaService();
			link = cadastrarEmpresa.executa(request, response);
		} else if (acao.equals("/editarEmpresa")) {
			EditarEmpresaService editarEmpresa = new EditarEmpresaService();
			link = editarEmpresa.executa(request, response);
		} else if (acao.equals("/alterarEmpresa")) {
			AlterarEmpresaService alterarEmpresa = new AlterarEmpresaService();
			link = alterarEmpresa.executa(request, response);
		} else if (acao.equals("/removerEmpresa")) {
			RemoverEmpresaService removerEmpresa = new RemoverEmpresaService();
			link = removerEmpresa.executa(request, response);
		} else if (acao.equals("/formEmpresa")) {
			FormEmpresaService formEmpresa = new FormEmpresaService();
			link = formEmpresa.executa(request, response);
		} 
		
		String[] acaoAndUrl = link.split(":");
		
		if (acaoAndUrl[0].equals("foward")) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/view/" + acaoAndUrl[1]);
			dispatcher.forward(request, response);
		} else {
			response.sendRedirect(acaoAndUrl[1]);
		}
	}
}
