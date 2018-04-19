package br.com.fiap.view;

import br.com.fiap.service.CandidatoService;
import br.com.fiap.service.PartidoService;
import br.com.fiap.to.PartidoTO;

public class CadastrarView {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*Scanner scn = new Scanner(System.in);
		System.out.println("Nome:");
		String nome = scn.next() + scn.nextLine();
		System.out.println("Apelido:");
		String apelido = scn.next() + scn.nextLine();
		System.out.println("Número:");
		int numero = scn.nextInt();
		System.out.println("Ficha limpa:");
		boolean fichaLimpa = scn.nextBoolean();
		
		CandidatoTO to = new CandidatoTO(nome, apelido, fichaLimpa, numero);
		scn.close();
		
		CandidatoService service = new CandidatoService();
		try {
			service.cadastrar(to);
			System.out.println("Mucho Bueno");
		}catch (Exception e) {
			// TODO: handle exception
			System.err.println(e.getMessage());
		}*/
		
		PartidoTO to = new PartidoTO("CACACA", 8768);
		PartidoService service = new PartidoService();
		try {
			service.cadastrar(to);
			System.out.println("Mucho Bueno");
		}catch (Exception e) {
			// TODO: handle exception
			System.err.println(e.getMessage());
		}
		
	}

}
