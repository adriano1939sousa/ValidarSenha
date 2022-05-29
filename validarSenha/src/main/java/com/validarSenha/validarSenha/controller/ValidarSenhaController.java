package com.validarSenha.validarSenha.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.validarSenha.provider.api.ValidarsenhaApi;
import com.validarSenha.provider.model.SenhaRepresentation;
import com.validarSenha.provider.model.SenhaValidadaRepresentation;
import com.validarSenha.validarSenha.service.ValidarSenhaService;

@RestController
public class ValidarSenhaController implements ValidarsenhaApi {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private ValidarSenhaService validarSenhaService;
	
	@Override
	public ResponseEntity<SenhaValidadaRepresentation> validarsenhaPost(SenhaRepresentation senha){
		logger.info("Controller - inicio validacao de senha.");
		boolean valida = validarSenhaService.validar(senha.getSenha());
		
		SenhaValidadaRepresentation response = new SenhaValidadaRepresentation();
		response.setSenhavalida(valida);
		
		logger.info("Controller - término validacao de senha.");
		return new ResponseEntity<>(response,HttpStatus.OK);
		
	}

}
