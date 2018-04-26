package br.com.fiap.ws.dao;


import java.util.List;

import br.com.fiap.exception.CommitException;
import br.com.fiap.exception.FindException;

public interface GenericDAO<Tabela, Chave> {

	public void cadastrar(Tabela t);
	public Tabela buscar(Chave codigo);
	public void modificar(Tabela t);
	public void apagar(Chave codigo) throws FindException;
	public void commit() throws CommitException;
	List<Tabela> listar();
}
