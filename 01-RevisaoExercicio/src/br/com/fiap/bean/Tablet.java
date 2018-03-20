package br.com.fiap.bean;

public class Tablet extends Produto implements Eletronico{

	private String modelo;
	private String marca;
	private String so;
	private boolean tem3g;
	
	public Tablet() {
		super();
	}
	
	public Tablet(int codigo, String titulo, double preco, String modelo, String marca, String so, boolean tem3g) {
		super(codigo, titulo, preco);
		this.modelo = modelo;
		this.marca = marca;
		this.so = so;
		this.tem3g = tem3g;
	}
	
	
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getSo() {
		return so;
	}
	public void setSo(String so) {
		this.so = so;
	}
	public boolean isTem3g() {
		return tem3g;
	}
	public void setTem3g(boolean tem3g) {
		this.tem3g = tem3g;
	}

	@Override
	public double calcularValorGarantiaEst(double valor) {
		return valor * 0.05;
	}
	
	
	
}
