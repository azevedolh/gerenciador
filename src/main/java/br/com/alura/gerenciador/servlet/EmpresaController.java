package br.com.alura.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.alura.gerenciador.acao.Acao;

@WebServlet("/empresa")
public class EmpresaController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String acao = request.getParameter("acao");
		
		if (acao == null) {
			acao = "EmpresaHome";
		}
		
//      VERIFICA AUTORIZACOES DE ACESSO		
		HttpSession sessao = request.getSession();
		
		boolean usuarioNaoEstaLogado = (sessao.getAttribute("usuarioLogado") == null);
		boolean acaoProtegida = !(acao.equals("EmpresaHome") || acao.equals("FormLogin") || acao.equals("Login"));
		
		if (acaoProtegida && usuarioNaoEstaLogado) {
			response.sendRedirect("empresa?acao=FormLogin");
			return;
		}
		
		String link = null;
		
		try {
			Class classe = Class.forName("br.com.alura.gerenciador.acao." + acao);
			Acao objeto = (Acao)classe.newInstance();
			link = objeto.executa(request, response);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
			throw new ServletException(e);
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
