package br.com.fiap.jsf.bean;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class IndexBean {

	private String login;
	private String senha;
	
	public void logar() {
		if(getLogin().toUpperCase().equals("FIAP") && getSenha().equals("FIAP2018")) {
			System.out.println("Logado!");
		}
		else {
			System.out.println("Tente novamente :(");
		}
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
	
}
