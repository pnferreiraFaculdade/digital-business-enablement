package br.com.fiap.jsf.bean;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import br.com.fiap.service.CandidatoService;
import br.com.fiap.to.CandidatoTO;

@ManagedBean
public class CandidatoBean {

	private CandidatoTO candidato;
	private CandidatoService service;
	
	
	
	//M�todo de inicializa��o
	@PostConstruct
	private void init() {
		candidato = new CandidatoTO();
	}
	
	public CandidatoTO getCandidato() {
		return candidato;
	}
	
	public void setCandidato(CandidatoTO candidato) {
		this.candidato = candidato;
	}
	
}
