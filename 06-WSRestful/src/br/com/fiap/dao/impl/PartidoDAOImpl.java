package br.com.fiap.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.dao.PartidoDAO;
import br.com.fiap.entity.Partido;

public class PartidoDAOImpl extends GenericDAOImpl<Partido, Integer> implements PartidoDAO{

	public PartidoDAOImpl(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}

}
