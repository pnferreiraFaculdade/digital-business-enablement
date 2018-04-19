package br.com.fiap.view;

import java.util.List;
import java.util.Scanner;

import br.com.fiap.service.CandidatoService;
import br.com.fiap.service.PartidoService;
import br.com.fiap.to.CandidatoTO;
import br.com.fiap.to.PartidoTO;

public class BuscaView {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		Scanner scn = new Scanner(System.in);
		//System.out.println("Codigo:");
		//int codigo = scn.nextInt();
		CandidatoService service = new CandidatoService();
		try {
			List<CandidatoTO> c = service.listar();
			for (CandidatoTO candidatoTO : c) {
				System.out.println(candidatoTO.getNome());
			}
			//System.out.println(service.buscar(codigo).getNome());
		}catch (Exception e) {
			// TODO: handle exception
			System.err.println(e.getMessage());
		}
		*/
		PartidoService service = new PartidoService();
		try {
			/*List<PartidoTO> c = service.listar();
			for (PartidoTO partidoTO : c) {
				System.out.println(partidoTO.getNome());
			}*/
			System.out.println(service.buscar(1).getNome());
		}catch (Exception e) {
			// TODO: handle exception
			System.err.println(e.getMessage());
		}
	}

}
