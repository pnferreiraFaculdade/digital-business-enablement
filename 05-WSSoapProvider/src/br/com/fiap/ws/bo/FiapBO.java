package br.com.fiap.ws.bo;

import org.apache.axis2.AxisFault;

public class FiapBO {

	public float calcularMedia(float nac, float am, float ps) {
		return 0.2f*nac + 0.3f*am + 0.5f*ps;
	}
	
	public float calcularPS(float nac, float am) {
		return (6 - (0.2f*nac + 0.3f*am))*2;
	}
	public float calcularPSMediaEsperada(float nac, float am, float mediaEsperada) throws AxisFault {
		float ps = (mediaEsperada - (0.2f*nac + 0.3f*am))*2;
		if(ps > 10)
		throw new AxisFault("Sinto Muito");
		else
		return ps;
	}
}
