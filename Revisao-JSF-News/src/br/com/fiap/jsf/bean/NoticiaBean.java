package br.com.fiap.jsf.bean;

import java.util.Calendar;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import br.com.fiap.ws.service.NoticiaService;
import br.com.fiap.ws.to.NoticiaTO;

@ManagedBean
public class NoticiaBean {

	private NoticiaTO noticia;
	
	private NoticiaService service;
	
	@PostConstruct
	private void init() {
		noticia = new NoticiaTO();
		//Inicializa a data
		noticia.setData(Calendar.getInstance());
		service = new NoticiaService();
	}

	public String cadastrar() {
		FacesMessage msg = null;
		try {
			if(noticia.getCodigo() == 0) {
				service.cadastrar(noticia);
				msg = new FacesMessage("Cadastrado com sucesso");
			}
			else {
				service.atualizar(noticia);
				msg = new FacesMessage("Atualizado com sucesso");
				return "lista-noticias";
			}
		}catch (Exception e) {
			// TODO: handle exception
			msg = new FacesMessage("Não foi possível cadastrar");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			e.printStackTrace();
		}
		FacesContext.getCurrentInstance().addMessage(null, msg);
		System.out.println("BUM <. .>");
		return "noticia";
	}
	
	public void deletar(int codigo) {
		try {
			service.apagar(codigo);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public List<NoticiaTO> getNoticias(){
		try {
			return service.listar();
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}
	
	public NoticiaBean() {
		// TODO Auto-generated constructor stub
		super();
	}
	
	public NoticiaBean(NoticiaTO noticia, NoticiaService service) {
		super();
		this.noticia = noticia;
		this.service = service;
	}



	public NoticiaTO getNoticia() {
		return noticia;
	}
	public void setNoticia(NoticiaTO noticia) {
		this.noticia = noticia;
	}
	
}
