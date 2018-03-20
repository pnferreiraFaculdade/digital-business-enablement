package br.com.fiap.ws.to;

public class BoletimTo {
	private String materia; 
	private int falta;
	private float media;
	private boolean aprovado;
	public BoletimTo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BoletimTo(String materia, int falta, float media, boolean aprovado) {
		super();
		this.materia = materia;
		this.falta = falta;
		this.media = media;
		this.aprovado = aprovado;
	}
	public String getMateria() {
		return materia;
	}
	public void setMateria(String materia) {
		this.materia = materia;
	}
	public int getFalta() {
		return falta;
	}
	public void setFalta(int falta) {
		this.falta = falta;
	}
	public float getMedia() {
		return media;
	}
	public void setMedia(float media) {
		this.media = media;
	}
	public boolean isAprovado() {
		return aprovado;
	}
	public void setAprovado(boolean aprovado) {
		this.aprovado = aprovado;
	}
	
	
}
