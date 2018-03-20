package br.com.fiap.bean;

import java.io.Serializable;

/**Classe de produto
 * 
 * @author Poliana N Ferreira
 * @version 1.0
 * @since Aula do dia 08/02/2018
 */

public class Produto implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private int codigo;
	private String nome;
	private double preco;
	private int qtd;
	private String marca;
	
	public Produto() {
		super();
	}
	
	public Produto(int codigo, String nome, double preco, int qtd, String marca) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.preco = preco;
		this.qtd = qtd;
		this.marca = marca;
	}
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	public int getQtd() {
		return qtd;
	}
	public void setQtd(int qtd) {
		this.qtd = qtd;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	
	
	
}
