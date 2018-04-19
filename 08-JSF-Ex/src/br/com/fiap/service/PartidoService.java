package br.com.fiap.service;

import java.util.Arrays;
import java.util.List;

import javax.ws.rs.core.MediaType;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import br.com.fiap.to.PartidoTO;

public class PartidoService {

	private static final String URL = "http://localhost:8080/06-WSRestful/api/partido";
	private Client client = Client.create();
	
	public void apagar(int codigo) throws Exception {
		WebResource resource = client.resource(URL).path(String.valueOf(codigo));
		ClientResponse response = resource
				//Formado dos dados qu serão enviado 
				.type(MediaType.APPLICATION_JSON)
				//Fa\ um POST com os valores do candiato
				.delete(ClientResponse.class);
				if(response.getStatus() != 204) {
					throw new Exception("Erro: " + response.getStatus());
				}
	}
	
	public void atualizar(PartidoTO p) throws Exception {
		WebResource resource = client.resource(URL).path(String.valueOf(p.getCodigo()));
		ClientResponse response = resource.type(MediaType.APPLICATION_JSON)
				.put(ClientResponse.class, p);
		if(response.getStatus() != 200) {
			throw new Exception("Erro: " + response.getStatus());
		}
	}
	
	public List<PartidoTO> listar() throws Exception{
		WebResource resource = client.resource(URL);
		ClientResponse response = resource
				//Formado dos dados qu serão enviado 
				.accept(MediaType.APPLICATION_JSON)
				//Fa\ um POST com os valores do candiato
				.get(ClientResponse.class);
				if(response.getStatus() != 200) {
					throw new Exception("Erro: " + response.getStatus());
				}
				return Arrays.asList(response.getEntity(PartidoTO[].class));
	}
	
	public PartidoTO buscar(int codigo) throws Exception {
		WebResource resource = client.resource(URL).path(String.valueOf(codigo));
		ClientResponse response = resource
				//Formado dos dados qu serão enviado 
				.accept(MediaType.APPLICATION_JSON)
				//Fa\ um POST com os valores do candiato
				.get(ClientResponse.class);
				if(response.getStatus() != 200) {
					throw new Exception("Erro: " + response.getStatus());
				}
				return response.getEntity(PartidoTO.class);
	}
	
	public void cadastrar(PartidoTO p) throws Exception {
		
		WebResource resource = client.resource(URL);
		//Chama o ws e recupera a resposta
		ClientResponse response = resource
				//Formado dos dados qu serão enviado 
				.type(MediaType.APPLICATION_JSON)
				//Fa\ um POST com os valores do candiato
				.post(ClientResponse.class, p);
				if(response.getStatus() != 201) {
					throw new Exception("Erro: " + response.getStatus());
				}
	}
	
}
