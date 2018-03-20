package br.com.fiap.config;

import java.io.IOException;
import java.util.Properties;

/**Classe Singleton para pegar valores de arquivos de propridades
 * 
 * @author Poliana N Ferreira
 * @version 1.0
 * @since Aula do dia 08/02/2018
 */
public class PropertySingleton {

	private static Properties p;
	
	/**M�todo construtor privado
	 * 
	 */
	private PropertySingleton() {}
	
	/** Criar uma inst�ncia �nica de properties
	 * 
	 * @return Properties - objeto �nico p
	 */
	public static Properties getInstance() {
		if(p == null) {
			p = new Properties();
			try {
				p.load(PropertySingleton.class.getResourceAsStream("/filiais.properties"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return p;
	}
	
}
