package br.fcom.fiap.config;

import java.io.IOException;
import java.util.Properties;

public class PropertySingleton {

	//Atributo est�tico do objeto que ser� �nico
	private static Properties p;
	
	//Construtor privado - ninguem consegue instanciar essa classe
	private PropertySingleton() {}
	
	//M�todo est�tico getInstance(), que devolve a inst�ncia
	public static Properties getInstance() {
		if(p == null) {
			p = new Properties();
			//Carregar o arquivo de propriedades na vari�vel p
			try {
				p.load(PropertySingleton.class.getResourceAsStream("/config.properties"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return p;
	}
	
}
