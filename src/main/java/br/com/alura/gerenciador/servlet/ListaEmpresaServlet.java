package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/listaEmpresas")
public class ListaEmpresaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		Banco banco = new Banco();
		List<Empresa> listaEmpresas = banco.getEmpresas();
		
		PrintWriter out = response.getWriter();
		
		out.println("<html><body>");
		out.println("<h1>Lista de Empresas: </h1>");
		out.println("<ul>");
		
		for (Empresa empresa : listaEmpresas) {
			out.println("<li>" + empresa.getNome() + "</li>");
		}
		
		out.println("</ul>"); 
		out.println("</body></html>");
	}

}
