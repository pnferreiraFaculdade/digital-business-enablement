package br.com.fiap.repository;

import java.rmi.RemoteException;
import java.util.Arrays;
import java.util.List;

import org.apache.axis2.AxisFault;

import br.com.fiap.loja.EstoqueBOStub;
import br.com.fiap.loja.EstoqueBOStub.CadastrarProduto;
import br.com.fiap.loja.EstoqueBOStub.CadastrarProdutoResponse;
import br.com.fiap.loja.EstoqueBOStub.ConsultarProduto;
import br.com.fiap.loja.EstoqueBOStub.ConsultarProdutoResponse;
import br.com.fiap.loja.EstoqueBOStub.HasProduto;
import br.com.fiap.loja.EstoqueBOStub.HasProdutoResponse;
import br.com.fiap.loja.EstoqueBOStub.Listar;
import br.com.fiap.loja.EstoqueBOStub.ListarResponse;
import br.com.fiap.loja.EstoqueBOStub.NextCodigo;
import br.com.fiap.loja.EstoqueBOStub.NextCodigoResponse;
import br.com.fiap.loja.EstoqueBOStub.Produto;

public class EstoqueRepository {

	EstoqueBOStub stub;

	public EstoqueRepository() throws AxisFault {
		stub = new EstoqueBOStub();
	}
	
	public String cadastrarProd(Produto p) throws RemoteException {
		CadastrarProduto cadastrar = new CadastrarProduto();
		cadastrar.setPInserido(p);
		CadastrarProdutoResponse resposta = stub.cadastrarProduto(cadastrar);
		return resposta.get_return();
	}
	
	public Produto consultarProd(int codigo) throws RemoteException {
		ConsultarProduto consultar = new ConsultarProduto();
		consultar.setCodigo(codigo);
		ConsultarProdutoResponse resposta = stub.consultarProduto(consultar);
		return resposta.get_return();
	}
	
	public boolean hasProd() throws RemoteException {
		HasProduto tem = new HasProduto();
		HasProdutoResponse resposta = stub.hasProduto(tem);
		return resposta.get_return();
	}
	
	public int nextCod() throws RemoteException {
		NextCodigo next = new NextCodigo();
		NextCodigoResponse resposta = stub.nextCodigo(next);
		return resposta.get_return();
	}
	
	public List<Produto> listarProd() throws RemoteException {
		Listar list = new Listar();
		ListarResponse resposta = stub.listar(list);
		return Arrays.asList(resposta.get_return());
	}
	
	
	
}
