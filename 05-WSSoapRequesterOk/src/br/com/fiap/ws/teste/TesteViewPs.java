package br.com.fiap.ws.teste;

import java.util.Scanner;

import br.com.fiap.ws.bo.FiapBOStub;
import br.com.fiap.ws.bo.FiapBOStub.CalcularPS;
import br.com.fiap.ws.bo.FiapBOStub.CalcularPSResponse;

public class TesteViewPs {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		FiapBOStub stub = new FiapBOStub(); 
		CalcularPS parametro = new CalcularPS();
		
		Scanner scn = new Scanner(System.in);
		System.out.println("Digite a média de nac: ");
		float nac = scn.nextFloat();
		System.out.println("Digite a nota de am: ");
		float am = scn.nextFloat();
		parametro.setAm(am);
		parametro.setNac(nac);
		
		CalcularPSResponse resposta = stub.calcularPS(parametro);
		float media = resposta.get_return();
		System.out.printf("Você precisa de : %.2f", media);
		scn.close();
	}

}
