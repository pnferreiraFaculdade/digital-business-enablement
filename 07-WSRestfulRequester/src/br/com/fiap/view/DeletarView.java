package br.com.fiap.view;

import java.util.List;
import java.util.Scanner;

import br.com.fiap.service.CandidatoService;
import br.com.fiap.to.CandidatoTO;

public class DeletarView {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scn = new Scanner(System.in);
		System.out.println("Codigo:");
		int codigo = scn.nextInt();
		CandidatoService service = new CandidatoService();
		try {
			service.apagar(codigo);
			System.out.println("Deeletado");
		}catch (Exception e) {
			// TODO: handle exception
			System.err.println(e.getMessage());
		}
	}

}
