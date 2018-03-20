package br.com.fiap.teste;

import java.rmi.RemoteException;
import java.util.Scanner;

import org.apache.axis2.AxisFault;
import org.tempuri.CalcPrecoPrazoWSStub;
import org.tempuri.CalcPrecoPrazoWSStub.CalcPrazo;
import org.tempuri.CalcPrecoPrazoWSStub.CalcPrazoResponse;

public class Teste {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		CalcPrecoPrazoWSStub stub;
		try {
			stub = new CalcPrecoPrazoWSStub();
			CalcPrazo parametro = new CalcPrazo();
			
			String codigo = "04014";
			System.out.println("Digite o cep de origem: ");
			String cepOrigem = scn.next();
			System.out.println("Digite o cep de destino: ");
			String cepDestino = scn.next();
			
			parametro.setSCepDestino(cepDestino);
			parametro.setSCepOrigem(cepOrigem);
			parametro.setNCdServico(codigo);
			
			CalcPrazoResponse resposta = stub.calcPrazo(parametro);
			System.out.println(resposta.getCalcPrazoResult().getServicos().getCServico()[0].getPrazoEntrega());
		} catch (AxisFault e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
