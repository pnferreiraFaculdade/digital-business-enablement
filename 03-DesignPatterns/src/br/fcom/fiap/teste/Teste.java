package br.fcom.fiap.teste;

import java.util.Properties;

import br.fcom.fiap.config.PropertySingleton;

public class Teste {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Recebe o objeto que carrega as configurações
		Properties p = PropertySingleton.getInstance();
		//Recupera uma config do arquivo
		String modo = p.getProperty("modo");
		System.out.println(modo);
		
	}

}
