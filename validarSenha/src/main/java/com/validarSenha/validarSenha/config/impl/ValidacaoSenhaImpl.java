package com.validarSenha.validarSenha.config.impl;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.validarSenha.validarSenha.config.ValidacaoSenha;

public class ValidacaoSenhaImpl implements ValidacaoSenha {

	private static final int TAMANHO_MINIMO = 9;
	private static final int TAMANHO_MAXIMO = 255;

	@Override
	public Boolean validar(String senha) {
		if(validarTamanhoMinimo(senha) && validarDigito(senha) 
			&& validarTamanhoMaximo(senha) && validarDigito(senha)
			&& validarLetraMaiuscula(senha) && validarLetraMinuscula(senha)
			&& validarCaracterEspecial(senha)) {
			return true;
		}
		return false;
	}

	// nove ou mais caracteres
	private boolean validarTamanhoMinimo(String senha) {
		if (senha.length() < TAMANHO_MINIMO) {
			return false;
		}
		return true;
	}
	
	// nove ou mais caracteres
		private boolean validarTamanhoMaximo(String senha) {
			if (senha.length() > TAMANHO_MAXIMO) {
				return false;
			}
			return true;
		}

	// Ao menos 1 digito
	private boolean validarDigito(String senha) {
		Pattern p = Pattern.compile("\\d");
		Matcher m = p.matcher(senha);

		if (m.matches()) {
			return true;
		} else {
			return false;
		}
	}

	// Ao menos 1 letra maiúscula
	private boolean validarLetraMaiuscula(String senha) {
		Pattern p = Pattern.compile("[A-Z]");
		Matcher m = p.matcher(senha);

		if (m.matches()) {
			return true;
		} else {
			return false;
		}

	}

	// Ao menos 1 letra minúscula
	private boolean validarLetraMinuscula(String senha) {
		Pattern p = Pattern.compile("[a-z]");
		Matcher m = p.matcher(senha);

		if (m.matches()) {
			return true;
		} else {
			return false;
		}

	}

	// Ao menos 1 caracter especial ( !@#$%^&*()-+ )
	private boolean validarCaracterEspecial(String senha) {

		Pattern p = Pattern.compile("[!@#$%^&*()-+]");
		Matcher m = p.matcher(senha);

		if (m.matches()) {
			return true;
		} else {
			return false;
		}

	}

	// Não possuir caracteres repetidos dentro do conjunto
	private boolean validarCaracterRepetido(String senha) {

		Set<Character> chars = new HashSet<>();
		for (Character character : chars) {
			if (!chars.add(character)) {
				return false;
			}
		}
		return true;
	}

}
