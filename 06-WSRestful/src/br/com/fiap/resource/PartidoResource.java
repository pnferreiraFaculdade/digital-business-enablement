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
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

import br.com.fiap.dao.PartidoDAO;
import br.com.fiap.dao.impl.PartidoDAOImpl;
import br.com.fiap.entity.Partido;
import br.com.fiap.exception.CommitException;
import br.com.fiap.exception.FindException;
import br.com.fiap.singleton.EntityManagerFactorySingleton;

@Path("/partido")
public class PartidoResource {

	private PartidoDAO dao;
	 public PartidoResource() {
		// TODO Auto-generated constructor stub
		 EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		 dao = new PartidoDAOImpl(em);
	 }
	

		@GET
		@Path("{id}")
		@Produces(MediaType.APPLICATION_JSON)
		public Partido buscar(@PathParam("id") int codigo) {
			return dao.buscar(codigo);
		}

		@GET
		@Produces(MediaType.APPLICATION_JSON)
		public List<Partido> listar() {
			return dao.listar();
		}

		@POST
		@Consumes(MediaType.APPLICATION_JSON)
		public Response cadastrar(Partido p, @Context UriInfo uri) {
			try {
				dao.cadastrar(p);
				dao.commit();
				UriBuilder b = uri.getAbsolutePathBuilder();
				b.path(String.valueOf(p.getCodigo()));
				// Cria resposta 201 created
				return Response.created(b.build()).build();
			} catch (CommitException e) {
				return Response.serverError().build();
			}
		}

		@PUT
		@Path("/{id}")
		@Consumes(MediaType.APPLICATION_JSON)
		public Response atulizar(Partido p, @PathParam("id") int codigo) {
			try {
				p.setCodigo(codigo);
				dao.modificar(p);
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
