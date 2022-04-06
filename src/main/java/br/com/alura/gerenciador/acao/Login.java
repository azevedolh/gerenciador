package br.com.alura.gerenciador.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.modelo.Banco;

public class Login implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		
		System.out.println("Logando Usu�rio: " + login);

		Banco banco = new Banco();
		boolean isLoginValido = banco.getUsuarios().stream().anyMatch(e -> e.ehIgual(login, senha));
		
		if (isLoginValido) {
			System.out.println("Sucesso no Login, usu�rio " + login);
			return "redirect:empresa?acao=ListaEmpresas";
		}

		System.out.println("Falha no Login, usu�rio " + login + ". Usu�rio ou senha incorretos");
		return "redirect:empresa?acao=FormLogin";
	}

}
