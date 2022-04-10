package br.com.alura.gerenciador.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.alura.gerenciador.modelo.Banco;
import br.com.alura.gerenciador.modelo.Usuario;

public class Login implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		
		System.out.println("Logando Usuário: " + login);

		Banco banco = new Banco();
		Usuario usuario = banco.verificaExistenciaUsuario(login, senha);
		
		if (usuario != null) {
			System.out.println("Sucesso no Login, usuário " + login);
			HttpSession sessao = request.getSession();
			sessao.setAttribute("usuarioLogado", usuario);
			return "redirect:empresa?acao=ListaEmpresas";
		}

		System.out.println("Falha no Login, usuário " + login + ". Usuário ou senha incorretos");
		return "redirect:empresa?acao=FormLogin";
	}

}
