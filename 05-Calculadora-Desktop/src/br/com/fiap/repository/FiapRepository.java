package br.com.fiap.repository;

import java.rmi.RemoteException;

import org.apache.axis2.AxisFault;

import br.com.fiap.ws.bo.FiapBOStub;
import br.com.fiap.ws.bo.FiapBOStub.CalcularMedia;
import br.com.fiap.ws.bo.FiapBOStub.CalcularMediaResponse;

public class FiapRepository {

	private FiapBOStub stub;
	
	
	
	public FiapRepository() throws AxisFault {
		super();
		stub = new FiapBOStub();
	}



	public float calcularMedia(float am, float nac , float ps) throws RemoteException {
		CalcularMedia calc = new CalcularMedia();
		calc.setAm(am);
		calc.setNac(nac);
		calc.setPs(ps);
		CalcularMediaResponse media = stub.calcularMedia(calc);
		
		return media.get_return();
	}
	
}
