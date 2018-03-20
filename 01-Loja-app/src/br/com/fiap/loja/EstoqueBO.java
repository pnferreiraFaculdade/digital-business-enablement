package br.com.fiap.loja;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.fiap.bean.Produto;

/**Classe BO para regras de neg�cio do estoque
 * 
 * @author Poliana N Ferreira
 * @version 1.0
 * @since Aula do dia 08/02/2018
 */

public class EstoqueBO{
	
	private static final Logger log = LoggerFactory.getLogger(EstoqueBO.class);
	
	static List<Produto> lp = new ArrayList<Produto>();
	//Produto(String nome, double preco, int qtd, String marca) {
	
	/**M�todo est�tico para cadastrar produtos na lista
	 * 
	 * @param pInserido  - produto para cadastrar
	 * @return String - mensagem
	 */
	public static String cadastrarProduto(Produto pInserido) {
		log.info("Validando se codigo ainda n�o existe");
		for (Produto produto : lp) {
			if(pInserido.getCodigo() == produto.getCodigo()) {
				return "Codigo invalido";
			}
		}
		lp.add(pInserido);
		log.info("Produto adicionado");
		return "Show";
	}
	
	/**M�todo para checar se algum produto j� foi cadastrado
	 * 
	 * @return Boolean - se tem produto na lista
	 */
	public static boolean hasProduto() {
		return lp.isEmpty();
	} 
	
	/** M�todo para consultar produto atrav�s do c�digo
	 * 
	 * @param codigo - int
	 * @return Produto - produto relacionado ao c�digo informado
	 */
	public static Produto consultarProduto(int codigo) {
		Produto p;
		log.info("Consultando produto " + codigo);
		for (Produto produto : lp) {
			if(codigo == produto.getCodigo()) {
				p = produto;
				log.info("Produto encontrado");
				return p;
			}
		}
		System.out.println("Produto n�o cadastrado");
		log.error("Produto n�o cadastrado");
		return null; 
	}
	
}
