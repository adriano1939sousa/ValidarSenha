package com.validarSenha.validarSenha.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest
@TestPropertySource(locations = "classpath:application.properties")
public class ValidarSenhaServiceTest {
	

	@Autowired
	ValidarSenhaService validarSenhaService;
	
	
	@Test
	public void validar() {
		// Act
		boolean senhaValida = validarSenhaService.validar("Senha@123");

		// Print
		System.out.println(senhaValida);
	}

}
