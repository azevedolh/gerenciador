package br.com.alura.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class AcaoFilter implements Filter {
	
	@Override
	public void destroy() {}	

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {}
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		String acao = request.getParameter("acao");
		
		if (acao == null) {
			acao = "EmpresaHome";
		}
		
		request.setAttribute("acao", acao);
		
		chain.doFilter(request, response);
	}

}
