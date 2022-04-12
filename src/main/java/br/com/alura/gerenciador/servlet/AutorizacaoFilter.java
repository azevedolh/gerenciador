package br.com.alura.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AutorizacaoFilter implements Filter {

	public void destroy() {
	}	

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}
	
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse; 
		
		String acao = (String)request.getAttribute("acao");
		
		HttpSession sessao = request.getSession();
		
		boolean usuarioNaoEstaLogado = (sessao.getAttribute("usuarioLogado") == null);
		boolean acaoProtegida = !(acao.equals("EmpresaHome") || acao.equals("FormLogin") || acao.equals("Login"));
		
		if (acaoProtegida && usuarioNaoEstaLogado) {
			sessao.setAttribute("urlAnterior", acao);
			response.sendRedirect("empresa?acao=FormLogin");
			return;
		}
		
		chain.doFilter(request, response);
	}

}
