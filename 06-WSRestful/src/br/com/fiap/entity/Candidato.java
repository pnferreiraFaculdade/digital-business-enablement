package br.com.fiap.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "T_JWSR_CANDIDATO")
@SequenceGenerator(allocationSize = 1, name = "cand", sequenceName = "SQ_T_JWSR_CANDIDATO", initialValue =1)
public class Candidato {
	@Id
	@Column(name = "cd_candidato")
	@GeneratedValue(generator = "cand", strategy = GenerationType.SEQUENCE)
	private int codigo;
	@Column(name = "nm_candidato", nullable = false, length = 250)
	private String nome;
	@Column(name = "ds_apelido", length = 250)
	private String apelido;
	@Column(name = "nr_candidato", nullable = false)
	private int numero;
	@Column(name = "fl_ficha_limpa", nullable = false)
	private boolean fichaLimpa;
	
	
	
	public Candidato(String nome, String apelido, int numero, boolean fichaLimpa) {
		super();
		this.nome = nome;
		this.apelido = apelido;
		this.numero = numero;
		this.fichaLimpa = fichaLimpa;
	}
	
	public Candidato() {super();}
	
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
	public String getApelido() {
		return apelido;
	}
	public void setApelido(String apelido) {
		this.apelido = apelido;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public boolean isFichaLimpa() {
		return fichaLimpa;
	}
	public void setFichaLimpa(boolean fichaLimpa) {
		this.fichaLimpa = fichaLimpa;
	}
	
}
