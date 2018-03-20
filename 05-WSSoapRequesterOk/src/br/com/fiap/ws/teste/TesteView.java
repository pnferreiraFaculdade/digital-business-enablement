package br.com.fiap.ws.teste;

import br.com.fiap.ws.bo.FiapBOStub;
import br.com.fiap.ws.bo.FiapBOStub.CalcularMedia;
import br.com.fiap.ws.bo.FiapBOStub.CalcularMediaResponse;

public class TesteView {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		FiapBOStub stub = new FiapBOStub(); 
		CalcularMedia parametro = new CalcularMedia();
		parametro.setAm(2);
		parametro.setNac(5);
		parametro.setPs(5);
		
		CalcularMediaResponse resposta = stub.calcularMedia(parametro);
		float media = resposta.get_return();
		System.out.println("A média é: " + media);
		
	}

}
