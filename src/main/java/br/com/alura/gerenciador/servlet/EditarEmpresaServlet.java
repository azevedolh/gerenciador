package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/editarEmpresa")
public class EditarEmpresaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer id = Integer.valueOf(request.getParameter("id"));
		
		Banco banco = new Banco();
		Empresa empresa = banco.getEmpresaById(id);
		
		request.setAttribute("empresa", empresa);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/formAlteraEmpresa.jsp");
		dispatcher.forward(request, response);
	}
}
