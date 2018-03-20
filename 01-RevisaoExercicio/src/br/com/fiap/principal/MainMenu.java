package br.com.fiap.principal;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.com.fiap.bean.Tablet;

public class MainMenu {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		List<Tablet> lt = new ArrayList<Tablet>();
		int codigo = -1;
		while(codigo != 0) {
			System.out.println("O que deseja fazer agora?\n1 – Cadastrar Tablet: leia as informações fornecidas pelo usuário\r\n" + 
					"e instancie um tablet, depois armazene-o em um vetor/lista;\n" + 
					"2 – Exibir tablets cadastrados: imprima no console os valores;\n" + 
					"dos tablets cadastrados;\n" + 
					"0 – Sair: finaliza o programa.");
			codigo = scn.nextInt();
			switch(codigo) {
				case 1:
					System.out.println("Cadastrando um novo tablet!");
					Tablet t = new Tablet();
					
					System.out.print("Digite o codigo: ");
					t.setCodigo(scn.nextInt());
					System.out.print("Digite o titulo: ");
					t.setTitulo(scn.next());
					System.out.print("Digite o preco: ");
					t.setPreco(scn.nextDouble());
					System.out.print("Digite o modelo: ");
					t.setModelo(scn.next());
					System.out.print("Digite a marca: ");
					t.setMarca(scn.next());
					System.out.print("Digite o sistema operacional: ");
					t.setModelo(scn.next());
					System.out.print("Digite se tem 3G: ");
					t.setTem3g(scn.nextBoolean());
					lt.add(t);
					break;
				case 2:
					for (Tablet tablet : lt) {
						System.out.println("Tablet: " + tablet.getCodigo() + " " + tablet.getMarca() + " " + tablet.getModelo() + " "
								+ tablet.getPreco() + " " + tablet.getSo() +  " " + tablet.getTitulo() + " " + tablet.isTem3g());	
					}
					if(lt.isEmpty()) System.out.println("Você ainda não cadastrou nada!");
					break;
				case 0:
					System.out.println("Saindo");
					break;
				default:
					System.out.println("Codigo errado");
			}
		}

		scn.close();
	}

}
