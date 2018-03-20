package br.com.fiap.ws.bo;

import br.com.fiap.ws.to.BoletimTo;

public class BoletimBO {
	
	public BoletimTo buscar(int codigo) {
		BoletimTo to = null;
		switch(codigo) {
		case 1:
			to = new BoletimTo("Android", 0, 10, true);
			break;
		case 2:
			to = new BoletimTo("IOT", 2, 5, false);
			break;
		}
		return to;
	}
	
}
