package br.com.fiap.teste;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.fiap.bo.ConversaoMetricaBO;

public class Teste {

	private static Logger log = LoggerFactory.getLogger(Teste.class);
	
	public static void main(String[] args) {
		log.debug("Iniciando a aplicação");
		ConversaoMetricaBO bo = new ConversaoMetricaBO();
		double milhas = bo.converterMilhas(100);
		System.out.printf("100km = %2f milhas\n", milhas);
		
		double pol = bo.converterPolegada(43);
		System.out.printf("100cm = %2f polegadas", pol);
		log.warn("Finalizando a aplicação");
	}

}
