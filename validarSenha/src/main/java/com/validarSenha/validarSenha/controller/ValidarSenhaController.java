package com.validarSenha.validarSenha.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.validarSenha.provider.api.ValidarsenhaApi;
import com.validarSenha.provider.model.SenhaRepresentation;
import com.validarSenha.provider.model.SenhaValidadaRepresentation;
import com.validarSenha.validarSenha.service.ValidarSenhaService;

@RestController
public class ValidarSenhaController implements ValidarsenhaApi {
	
	private ValidarSenhaService validarSenhaService;
	
	
	public ValidarSenhaController (ValidarSenhaService validarSenhaService) {
		this.validarSenhaService= validarSenhaService;
	}
	
	@Override
	public ResponseEntity<SenhaValidadaRepresentation> validarsenhaPost(SenhaRepresentation senha){
		
		boolean valida = validarSenhaService.validar(senha.getSenha());
		
		SenhaValidadaRepresentation response = new SenhaValidadaRepresentation();
		response.setSenhavalida(valida);
		
		
		return new ResponseEntity<>(response,HttpStatus.OK);
		
	}

}
