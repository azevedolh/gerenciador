package br.com.alura.gerenciador.acao;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.modelo.Banco;
import br.com.alura.gerenciador.modelo.Empresa;

public class CadastrarEmpresa implements Acao {
	public String executa(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String nomeEmpresa = request.getParameter("nome");
		String paramDataAbertura = request.getParameter("dataAbertura");
		
		System.out.println("Cadastrando nova empresa " + nomeEmpresa );
		
		Date dataAbertura;
		try {
			SimpleDateFormat smp = new SimpleDateFormat("dd/MM/yyyy");
			dataAbertura = smp.parse(paramDataAbertura);
		} catch (ParseException e) {
			throw new ServletException(e);
		}
		
		Empresa empresa = new Empresa(nomeEmpresa, dataAbertura);
		Banco banco = new Banco();
		banco.adicionar(empresa);
		
		return "redirect:empresa?acao=ListaEmpresas";
	}
}
