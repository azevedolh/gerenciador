package br.com.alura.gerenciador.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.alura.gerenciador.modelo.Banco;
import br.com.alura.gerenciador.modelo.Usuario;

public class Logout implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		HttpSession sessao = request.getSession();
		Usuario usuarioLogado = (Usuario)sessao.getAttribute("usuarioLogado");
		System.out.println("Deslogando Usuário " + usuarioLogado.getLogin());
		sessao.invalidate();
		return "redirect:empresa?=EmpresaHome";
	}

}
