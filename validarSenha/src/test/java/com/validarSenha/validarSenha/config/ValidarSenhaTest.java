package com.validarSenha.validarSenha.config;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import com.validarSenha.validarSenha.config.impl.ValidacaoSenhaImpl;

@SpringBootTest
@TestPropertySource(locations = "classpath:application.properties")
public class ValidarSenhaTest {
	@Autowired
	ValidacaoSenhaImpl validacaoSenhaImpl;
	@Test
	public void validarTest() {
		validacaoSenhaImpl.validar("Senha@123");
		
	}
	
}
