package com.validarSenha.validarSenha.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.validarSenha.validarSenha.config.ValidacaoSenha;

@Service
public class ValidarSenhaService {
	
	private ValidacaoSenha validacaoSenha;
	
	
	@Autowired
	public ValidarSenhaService(ValidacaoSenha validacao) {
		this.validacaoSenha = validacao;
		
	}
	
	public boolean validar(String senha) {
		return validacaoSenha.validar(senha);
	}

}
