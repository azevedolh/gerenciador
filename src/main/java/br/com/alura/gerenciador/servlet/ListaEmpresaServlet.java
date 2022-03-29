package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/listaEmpresas")
public class ListaEmpresaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		Banco banco = new Banco();
		List<Empresa> listaEmpresas = banco.getEmpresas();
		
		request.setAttribute("listaEmpresas", listaEmpresas);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/listaEmpresas.jsp");
		dispatcher.forward(request, response);
	}

}
