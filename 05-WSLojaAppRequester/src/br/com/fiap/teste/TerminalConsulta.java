package br.com.fiap.teste;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.rmi.RemoteException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Scanner;

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

/**
 * 
 * @author Poliana N Ferreira
 * @version 1.1
 * @since Aula do dia 08/02/2018
 */

public class TerminalConsulta {

	
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
	
	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		Produto p = null;
		Calendar hoje;
		SimpleDateFormat formata = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		SimpleDateFormat formataArq = new SimpleDateFormat("yyyy-MM-dd");
		int codigo, opcao=-1;
		String filial = "FIAP";
		EstoqueBOStub stub = new EstoqueBOStub();
		CadastrarProduto cadastrar = new CadastrarProduto();
		HasProduto tem = new HasProduto();
		NextCodigo nextCod = new NextCodigo();
		Listar listar = new Listar();
		ConsultarProduto consultar = new ConsultarProduto();
		DecimalFormat df = new DecimalFormat("R$#,###.00");
		FileWriter arquivo;
		StringBuilder contArquivo = new StringBuilder();
		while(opcao != 0) {
			
			hoje = Calendar.getInstance();
			System.out.println("\n" + filial + addEspaco(filial) + formata.format(hoje.getTime()) + "\n"
					+ msg);
			System.out.println("1-Cadastrar\n2-Consultar\n3-Listar todos\n0-Sair :)");
			opcao = scn.nextInt();
			switch(opcao) {
				case 1:
					p = new Produto();
					NextCodigoResponse cod = stub.nextCodigo(nextCod);
					p.setCodigo(cod.get_return());
					System.out.print("Digite o nome: ");
					p.setNome(scn.next());
					System.out.print("Digite o preco: ");
					p.setPreco(scn.nextDouble());
					System.out.print("Digite a qtd: ");
					p.setQtd(scn.nextInt());
					System.out.print("Digite a marca: ");
					p.setMarca(scn.next());
					cadastrar.setPInserido(p);
					CadastrarProdutoResponse resposta = stub.cadastrarProduto(cadastrar);
					System.out.println(resposta.get_return());
					break;
				case 2:
					HasProdutoResponse respostaTem = stub.hasProduto(tem);
					if (respostaTem.get_return()) {
						System.out.println("Nenhum produto cadastrado :(");
						break;
					}
					System.out.print("Codigo do Produto: ");
					codigo = scn.nextInt();
					consultar.setCodigo(codigo);
					
					try {
						ConsultarProdutoResponse respostaConsulta = stub.consultarProduto(consultar);
						p = respostaConsulta.get_return();
					} catch (Exception e) {
						System.out.println("Produto não cadastrado");
						break;
					}
					System.out.println("\nCodigo: " + p.getCodigo() + "\nMarca: " + p.getMarca() + "\nNome: " +
							p.getNome() + "\nPreco: " + df.format(p.getPreco()) + "\nQuantidade: " + p.getQtd() );
					
					
					break;
				case 3:
					ListarResponse produtos = stub.listar(listar);
					System.out.println("Todos os produto cadastrados: ");
					contArquivo.append("<style> table {border: 1px solid black;border-collapse: collapse;width: 100%;}"
							+ "th {height: 50px;border: 1px solid black;}" + 
							"td {border: 1px solid black;}</style>");
					contArquivo.append("<table><tr><th>Codigo</th><th>Marca</th><th>Nome</th><th>Preco</th><th>Qtd</th></tr>");
					for (Produto pd : Arrays.asList(produtos.get_return())) {
						System.out.println("\nCodigo: " + pd.getCodigo() + "\nMarca: " + pd.getMarca() + "\nNome: " +
								pd.getNome() + "\nPreco: " + df.format(pd.getPreco()) + "\nQuantidade: " + pd.getQtd() );
						//contArquivo.append("\r\nCodigo: " + pd.getCodigo() + "\r\nMarca: " + pd.getMarca() + "\r\nNome: " +
						//		pd.getNome() + "\r\nPreco: " + df.format(pd.getPreco()) + "\r\nQuantidade: " + pd.getQtd() + "\r\n");
						contArquivo.append("<tr><td>"+ pd.getCodigo() +"</td><td>" + pd.getMarca() + "</td><td>" + pd.getNome() + 
								"</td><td>" + df.format(pd.getPreco()) + "</td><td>" + pd.getQtd() + "</td></tr>");
					}
					contArquivo.append("</table>");
					arquivo = new FileWriter(new File("D:/Relatorio" + formataArq.format(hoje.getTime()) + ".html"));
					arquivo.write(contArquivo.toString());
					arquivo.close();
					break;
				case 0:
					System.out.println("Tchau");
					break;
				default:
					System.out.println("Opcao invalida");
				
			}
			
		}
		scn.close();
		
		
		
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
