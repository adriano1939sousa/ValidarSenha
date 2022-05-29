package com.validarSenha.validarSenha.config.impl;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.validarSenha.validarSenha.config.ValidacaoSenha;


@Component("regraDefault")
public class ValidacaoSenhaImpl implements ValidacaoSenha {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	private static final int TAMANHO_MINIMO = 9;
	private static final int TAMANHO_MAXIMO = 255;

	@Override
	public Boolean validar(String senha) {
		if(validarTamanhoMinimo(senha) && validarDigito(senha) 
			&& validarTamanhoMaximo(senha) && validarCaracterRepetido(senha)
			&& validarLetraMaiuscula(senha) && validarLetraMinuscula(senha)
			&& validarCaracterEspecial(senha)) {
			return true;
		}
		return false;
	}

	// nove ou mais caracteres
	private boolean validarTamanhoMinimo(String senha) {
		logger.info("validarTamanhoMinimo - inicio validacao de senha.");
		if (senha.length() < TAMANHO_MINIMO) {
			return false;
		}
		return true;
	}
	
	// nove ou mais caracteres
		private boolean validarTamanhoMaximo(String senha) {
			logger.info("validarTamanhoMaximo - inicio validacao de senha.");
			if (senha.length() > TAMANHO_MAXIMO) {
				return false;
			}
			return true;
		}

	// Ao menos 1 digito
	private boolean validarDigito(String senha) {
		logger.info("validarDigito - inicio validacao de senha.");
		char[] chars = senha.toCharArray();
		for (Character c : chars) {
			if(c.isDigit(c)) {
				return true;
			}
		}
		return false;
	}

	// Ao menos 1 letra maiúscula
	private boolean validarLetraMaiuscula(String senha) {
		logger.info("validarLetraMaiuscula - inicio validacao de senha.");
		char[] chars = senha.toCharArray();
		for (Character c : chars) {
			if(c.isUpperCase(c)) {
				return true;
			}
		}
		return false;
	}

	// Ao menos 1 letra minúscula
	private boolean validarLetraMinuscula(String senha) {
		logger.info("validarLetraMinuscula - inicio validacao de senha.");
		char[] chars = senha.toCharArray();
		for (Character c : chars) {
			if(c.isLowerCase(c)) {
				return true;
			}
		}
		return false;

	}

	// Ao menos 1 caracter especial ( !@#$%^&*()-+ )
	private boolean validarCaracterEspecial(String senha) {
		logger.info("validarCaracterEspecial - inicio validacao de senha.");
		char [] chars = "!@#$%^&*()-+".toCharArray();
		for (Character c : chars) {
			if(Pattern.compile(Pattern.quote(c.toString()), Pattern.CASE_INSENSITIVE).matcher(senha).find()) {
				return true;
			}
		}
        
		return false;

	}

	// Não possuir caracteres repetidos dentro do conjunto
	private boolean validarCaracterRepetido(String senha) {
		logger.info("validarCaracterRepetido - inicio validacao de senha.");
		
		Set<Character> chars = new HashSet<>();
		for (Character character : senha.toCharArray()) {
			if (!chars.add(character)) {
				return false;
			}
		}
		return true;
	}

}
