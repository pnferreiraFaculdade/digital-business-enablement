package br.com.fiap.loja;

import java.util.ArrayList;
import java.util.List;

import org.apache.axis2.AxisFault;

import br.com.fiap.bean.Produto;

/**Classe BO para regras de negócio do estoque
 * 
 * @author Poliana N Ferreira
 * @version 1.0
 * @since Aula do dia 08/02/2018
 */

public class EstoqueBO{

	static List<Produto> lp = new ArrayList<Produto>();
	//Produto(String nome, double preco, int qtd, String marca) {
	
	/**Método estático para cadastrar produtos na lista
	 * 
	 * @param pInserido  - produto para cadastrar
	 * @return String - mensagem
	 */
	public String cadastrarProduto(Produto pInserido) {
		for (Produto produto : lp) {
			if(pInserido.getCodigo() == produto.getCodigo()) {
				return "Codigo invalido";
			}
		}
		lp.add(pInserido);
		return "Show";
	}
	
	/**Método para checar se algum produto já foi cadastrado
	 * 
	 * @return Boolean - se tem produto na lista
	 */
	public boolean hasProduto() {
		return lp.isEmpty();
	} 
	
	public int nextCodigo() {
		return lp.size() + 1;
	}
	/** Método para consultar produto através do código
	 * 
	 * @param codigo - int
	 * @return Produto - produto relacionado ao código informado
	 * @throws AxisFault 
	 */
	public Produto consultarProduto(int codigo) throws AxisFault {
		Produto p = null;
		for (Produto produto : lp) {
			if(codigo == produto.getCodigo()) {
				p = produto;
				return p;
			}
		}
		throw new AxisFault("Lixo"); 
	}
	
	public List<Produto> listar(){
		return lp;
	}
	
}
