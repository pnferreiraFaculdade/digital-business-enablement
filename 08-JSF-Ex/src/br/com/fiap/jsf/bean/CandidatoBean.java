package br.com.fiap.jsf.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import br.com.fiap.service.CandidatoService;
import br.com.fiap.to.CandidatoTO;

@ManagedBean
public class CandidatoBean {

	private CandidatoTO candidato;
	private CandidatoService service;
	
	public String cadastrar() {
		FacesMessage msg = null;
		try {
			if(candidato.getCodigo() == 0) {
				service.cadastrar(candidato);
				msg = new FacesMessage("Cadastrado com sucesso");
			}
			else {
				service.atualizar(candidato);
				msg = new FacesMessage("Atualizado com sucesso");
				return "lista-candidato";
			}
		}catch (Exception e) {
			// TODO: handle exception
			msg = new FacesMessage("Não foi possível cadastrar");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			e.printStackTrace();
		}
		FacesContext.getCurrentInstance().addMessage(null, msg);
		System.out.println("BUM <. .>");
		return "candidato";
	}
	
	public void deletar(int codigo) {
		try {
			service.apagar(codigo);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public List<CandidatoTO> getCandidatos(){
		try {
			return service.listar();
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}
	
	//Método de inicialização
	@PostConstruct
	private void init() {
		candidato = new CandidatoTO();
		service = new CandidatoService();
	}
	
	public CandidatoTO getCandidato() {
		return candidato;
	}
	
	public void setCandidato(CandidatoTO candidato) {
		this.candidato = candidato;
	}
	
}
