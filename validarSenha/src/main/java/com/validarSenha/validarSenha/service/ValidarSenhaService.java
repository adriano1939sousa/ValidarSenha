package com.validarSenha.validarSenha.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.validarSenha.validarSenha.config.ValidacaoSenha;

@Service
public class ValidarSenhaService {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private ValidacaoSenha validacaoSenha;
	
	
	public boolean validar(String senha) {
		logger.info("Service - inicio validacao de senha.");
		return validacaoSenha.validar(senha);
	}

}
