package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class MonitoramentoFilter implements Filter{
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		long tempoInicio = System.currentTimeMillis();
		String acao = (String)request.getAttribute("acao");
		
		chain.doFilter(request, response);
		
		long tempoFim = System.currentTimeMillis();
		System.out.println("Ação <" + acao + "> levou " + (tempoFim - tempoInicio) + " milisegundos para executar."); 
		
	}

	@Override
	public void destroy() {
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}
}
