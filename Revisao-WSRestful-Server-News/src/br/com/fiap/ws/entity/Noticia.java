package br.com.fiap.ws.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="T_DRE_NOTICIA")
@SequenceGenerator(allocationSize=1, name="noticia", sequenceName="SQ_T_DRE_NOTICIA")
public class Noticia {
	@Id
	@GeneratedValue(generator="noticia", strategy=GenerationType.SEQUENCE)
	private int codigo;
	private String titulo;
	private Calendar data;
	private boolean publicado;
	private String conteudo;
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public Calendar getData() {
		return data;
	}
	public void setData(Calendar data) {
		this.data = data;
	}
	public boolean isPublicado() {
		return publicado;
	}
	public void setPublicado(boolean publicado) {
		this.publicado = publicado;
	}
	public String getConteudo() {
		return conteudo;
	}
	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}
	public Noticia(String titulo, Calendar data, boolean publicado, String conteudo) {
		super();
		this.titulo = titulo;
		this.data = data;
		this.publicado = publicado;
		this.conteudo = conteudo;
	}
	public Noticia() {
		super();
	}
	
	
	
}
