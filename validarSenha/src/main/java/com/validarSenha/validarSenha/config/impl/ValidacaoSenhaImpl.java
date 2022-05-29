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
		try {
			if(validarTamanhoMinimo(senha) && validarDigito(senha) 
				&& validarTamanhoMaximo(senha) && validarCaracterRepetido(senha)
				&& validarLetraMaiuscula(senha) && validarLetraMinuscula(senha)
				&& validarCaracterEspecial(senha)) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	// nove ou mais caracteres
	private boolean validarTamanhoMinimo(String senha) throws Exception {
		logger.info("validarTamanhoMinimo - inicio validacao de senha.");
		if (senha.length() < TAMANHO_MINIMO) {
			throw new Exception("Tamanho mínimo da senha deve ser: "+ TAMANHO_MINIMO);			
		} 
			return true;
	}
	
	// nove ou mais caracteres
		private boolean validarTamanhoMaximo(String senha)throws Exception {
			logger.info("validarTamanhoMaximo - inicio validacao de senha.");
			if (senha.length() > TAMANHO_MAXIMO) {
				throw new Exception("Tamanho máximo da senha deve ser: "+ TAMANHO_MAXIMO);
			}
			return true;
		}

	// Ao menos 1 digito
	private boolean validarDigito(String senha)throws Exception {
		logger.info("validarDigito - inicio validacao de senha.");
		char[] chars = senha.toCharArray();
		for (Character c : chars) {
			if(c.isDigit(c)) {
				return true;
			}
		}
		throw new Exception("A senha deve conter no mínimo 1 digito ");
	}

	// Ao menos 1 letra maiúscula
	private boolean validarLetraMaiuscula(String senha)throws Exception {
		logger.info("validarLetraMaiuscula - inicio validacao de senha.");
		char[] chars = senha.toCharArray();
		for (Character c : chars) {
			if(c.isUpperCase(c)) {
				return true;
			}
		}
		throw new Exception("A senha deve conter no mínimo uma letra Maiuscula");
	}

	// Ao menos 1 letra minúscula
	private boolean validarLetraMinuscula(String senha)throws Exception {
		logger.info("validarLetraMinuscula - inicio validacao de senha.");
		char[] chars = senha.toCharArray();
		for (Character c : chars) {
			if(c.isLowerCase(c)) {
				return true;
			}
		}
		throw new Exception("A senha deve conter no mínimo uma letra Minúscula");

	}

	// Ao menos 1 caracter especial ( !@#$%^&*()-+ )
	private boolean validarCaracterEspecial(String senha)throws Exception {
		logger.info("validarCaracterEspecial - inicio validacao de senha.");
		char [] chars = "!@#$%^&*()-+".toCharArray();
		for (Character c : chars) {
			if(Pattern.compile(Pattern.quote(c.toString()), Pattern.CASE_INSENSITIVE).matcher(senha).find()) {
				return true;
			}
		}
        
		throw new Exception("A senha deve conter no mínimo um caracter especial do tipo '!@#$%^&*()-+'");

	}

	// Não possuir caracteres repetidos dentro do conjunto
	private boolean validarCaracterRepetido(String senha) throws Exception{
		logger.info("validarCaracterRepetido - inicio validacao de senha.");
		
		Set<Character> chars = new HashSet<>();
		for (Character character : senha.toCharArray()) {
			if (!chars.add(character)) {
				throw new Exception("A senha não deve conter itens repetidos");
			}
		}
		return true;
	}

}
