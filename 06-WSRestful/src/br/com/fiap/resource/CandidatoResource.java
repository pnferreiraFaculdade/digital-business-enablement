package br.com.fiap.resource;

import java.util.List;

import javax.persistence.EntityManager;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.core.Response.Status;

import br.com.fiap.dao.CandidatoDAO;
import br.com.fiap.dao.impl.CandidatoDAOImpl;
import br.com.fiap.entity.Candidato;
import br.com.fiap.exception.CommitException;
import br.com.fiap.exception.FindException;
import br.com.fiap.singleton.EntityManagerFactorySingleton;

@Path("/candidato")
public class CandidatoResource {

	private CandidatoDAO dao;

	public CandidatoResource() {
		// TODO Auto-generated constructor stub
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		dao = new CandidatoDAOImpl(em);
	}

	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Candidato buscar(@PathParam("id") int codigo) {
		return dao.buscar(codigo);
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Candidato> listar() {
		return dao.listar();
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response cadastrar(Candidato candidato, @Context UriInfo uri) {
		try {
			dao.cadastrar(candidato);
			dao.commit();
			UriBuilder b = uri.getAbsolutePathBuilder();
			b.path(String.valueOf(candidato.getCodigo()));
			// Cria resposta 201 created
			return Response.created(b.build()).build();
		} catch (CommitException e) {
			return Response.serverError().build();
		}
	}

	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response atulizar(Candidato candidato, @PathParam("id") int codigo) {
		try {
			candidato.setCodigo(codigo);
			dao.modificar(candidato);
			dao.commit();
			return Response.ok().build();
		} catch (CommitException e) {
			return Response.serverError().build();
		}
	}
	
	@DELETE
	@Path("/{id}")
	public void remover(@PathParam("id") int codigo) {
		try {
			dao.apagar(codigo);
			dao.commit();
		} catch (FindException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new WebApplicationException(Status.NOT_FOUND);
		} catch (CommitException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new WebApplicationException(Status.INTERNAL_SERVER_ERROR);
		}
		
		
	}
}
