package br.fcom.fiap.config;

import java.io.IOException;
import java.util.Properties;

public class PropertySingleton {

	//Atributo estático do objeto que será único
	private static Properties p;
	
	//Construtor privado - ninguem consegue instanciar essa classe
	private PropertySingleton() {}
	
	//Método estático getInstance(), que devolve a instância
	public static Properties getInstance() {
		if(p == null) {
			p = new Properties();
			//Carregar o arquivo de propriedades na variável p
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
