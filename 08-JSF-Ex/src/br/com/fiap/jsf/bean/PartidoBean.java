package br.com.fiap.jsf.bean;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import br.com.fiap.service.PartidoService;
import br.com.fiap.to.PartidoTO;
@ManagedBean
public class PartidoBean {

	private PartidoTO partido;
	private PartidoService service;
	public void cadastrar() {
		// TODO Auto-generated method stub
		FacesMessage msg = null;
		try {
			service.cadastrar(partido);
			msg = new FacesMessage("Cadastrado com sucesso");
		}catch (Exception e) {
			// TODO: handle exception
			msg = new FacesMessage("Não foi possível cadastrar");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			e.printStackTrace();
		}
		FacesContext.getCurrentInstance().addMessage(null, msg);
		System.out.println("BUM <. .>");
	}
	@PostConstruct
	private void init() {
		// TODO Auto-generated method stub
		partido = new PartidoTO();
		service = new PartidoService();
	}
	public PartidoTO getPartido() {
		return partido;
	}
	public void setPartido(PartidoTO partido) {
		this.partido = partido;
	}
	
}
