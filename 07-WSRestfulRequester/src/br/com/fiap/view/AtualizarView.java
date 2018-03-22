package br.com.fiap.view;

import java.util.Scanner;

import br.com.fiap.service.CandidatoService;
import br.com.fiap.to.CandidatoTO;

public class AtualizarView {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		System.out.println("Codigo:");
		int codigo = scn.nextInt();
		System.out.println("Nome:");
		String nome = scn.next() + scn.nextLine();
		System.out.println("Apelido:");
		String apelido = scn.next() + scn.nextLine();
		System.out.println("Número:");
		int numero = scn.nextInt();
		System.out.println("Ficha limpa:");
		boolean fichaLimpa = scn.nextBoolean();
		
		CandidatoTO to = new CandidatoTO(nome, apelido, fichaLimpa, numero);
		to.setCodigo(codigo);
		scn.close();
		
		CandidatoService service = new CandidatoService();
		try {
			service.atualizar(to);
			System.out.println("Mucho Bueno");
		}catch (Exception e) {
			// TODO: handle exception
			System.err.println(e.getMessage());
		}
	}

}
