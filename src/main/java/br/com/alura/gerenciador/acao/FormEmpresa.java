package br.com.alura.gerenciador.acao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FormEmpresa implements Acao {

	public String executa(HttpServletRequest request, HttpServletResponse response) {
		return "foward:formNovaEmpresa.jsp";
	}
}
