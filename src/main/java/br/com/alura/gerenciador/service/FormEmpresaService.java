package br.com.alura.gerenciador.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FormEmpresaService {

	public String executa(HttpServletRequest request, HttpServletResponse response) {
		return "foward:formNovaEmpresa.jsp";
	}
}
