package br.com.fiap.loja;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.fiap.bean.Produto;
import br.com.fiap.config.PropertySingleton;

/**
 * 
 * @author Poliana N Ferreira
 * @version 1.1
 * @since Aula do dia 08/02/2018
 */

public class TerminalConsulta {

	private static final Logger log = LoggerFactory.getLogger(TerminalConsulta.class);
	
	public static String msg = "**********Zero para sair*********";
	public static int tamHora = 19;
	
	/**Método para fazer contagem dos espaços 
	 * a serem colocados na cabeçalho do menu
	 * e deixar bonitinho 
	 * 
	 * @param nome - String
	 * @return String - espaços
	 */
	public static String addEspaco(String nome) {
		
		int numEspaco = msg.length() - nome.length() - tamHora;
		StringBuilder espaco = new StringBuilder();
		for (int i = 0; i < numEspaco; i++) {
			espaco.append(" ") ;
		}
		
		return espaco.toString() ;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		log.warn("Iniciando a aplicação");
		Scanner scn = new Scanner(System.in);
		Produto p;
		Calendar hoje;
		SimpleDateFormat formata = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		int codigo, opcao=-1;
		Properties ps = PropertySingleton.getInstance();
		log.info("Recuperando as configurações da aplicação");
		String filial = ps.getProperty("filial");
		DecimalFormat df = new DecimalFormat("R$#,###.00");
		
		while(opcao != 0) {
			
			hoje = Calendar.getInstance();
			System.out.println("\n" + filial + addEspaco(filial) + formata.format(hoje.getTime()) + "\n"
					+ msg);
			System.out.println("1-Cadastrar\n2-Consultar\n0-Sair :)");
			opcao = scn.nextInt();
			switch(opcao) {
				case 1:
					p = new Produto();
					System.out.print("Digite o codigo: ");
					p.setCodigo(scn.nextInt());
					System.out.print("Digite o nome: ");
					p.setNome(scn.next());
					System.out.print("Digite o preco: ");
					p.setPreco(scn.nextDouble());
					System.out.print("Digite a qtd: ");
					p.setQtd(scn.nextInt());
					System.out.print("Digite a marca: ");
					p.setMarca(scn.next());
					System.out.println(EstoqueBO.cadastrarProduto(p));
					break;
				case 2:
					if (EstoqueBO.hasProduto()) {
						log.info("Consultando produto: nenhum cadastrado");
						System.out.println("Nenhum produto cadastrado :(");
						break;
					}
					System.out.print("Codigo do Produto: ");
					codigo = scn.nextInt();
					p = EstoqueBO.consultarProduto(codigo);
					if(p != null)
					System.out.println(p.getCodigo() + " " + p.getMarca() + " " +
					p.getNome() + " " + df.format(p.getPreco()) + " " + p.getQtd() );
					break;
				case 0:
					System.out.println("Tchau");
					log.info("Usuario desligando o sistema");
					break;
				default:
					System.out.println("Opcao invalida");
				
			}
			
		}
		scn.close();
		log.warn("Finalizando a aplicação");
		
		
		
		/* V1
		Scanner scn = new Scanner(System.in);
		Calendar hoje;
		SimpleDateFormat formata = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		int codigo;
		while(true) {
			hoje = Calendar.getInstance();
			System.out.println("FIAP     " + formata.format(hoje.getTime()) + "\n"
					+ "*******Zero para sair*******");
			System.out.print("Codigo do Produto: ");
			codigo = scn.nextInt();
			if(codigo == 401) {
				System.out.println("Descricao: Camiseta Masculina Manga"
						+ " Curta Branca\n");
			}
			else if(codigo == 402) {
				System.out.println("Descricao: Camiseta Feminina Manga"
						+ " Longa Rosa\n");
			}
			else if(codigo == 0) break;
			else {
				System.out.println("Produto Nao Cadastrado!\n");
			}
		}
		scn.close();
	*/
	}

}
