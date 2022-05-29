package com.validarSenha.validarSenha.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.TestPropertySource;

import com.validarSenha.provider.model.SenhaRepresentation;
import com.validarSenha.provider.model.SenhaValidadaRepresentation;

@SpringBootTest
@TestPropertySource(locations = "classpath:application.properties")
public class ValidarSenhaControllerTest {
	@Autowired
	ValidarSenhaController validarSenhaController;
	
	@Test
	public void testController() {
		SenhaRepresentation senhavalidada = new SenhaRepresentation();
		senhavalidada.senha("Senha@123");
		
		ResponseEntity<SenhaValidadaRepresentation> retorno = validarSenhaController.validarsenhaPost(senhavalidada);
		
		System.out.println(retorno);
	}

}
