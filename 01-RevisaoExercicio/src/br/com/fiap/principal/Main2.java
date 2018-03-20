package br.com.fiap.principal;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.fiap.bean.Livro;

public class Main2 {

	public static void main(String[] args) {
		List<Livro> ll = new ArrayList<Livro>();
		SimpleDateFormat formata = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		
		ll.add(new Livro(1223, "um livro ruim", 87.99, 
				"autor bosta", "editora pior ainda", Calendar.getInstance()));
		ll.add(new Livro(1224, "um livro ruim 2", 88.99, 
				"autor bosta 2", "editora pior ainda 2", Calendar.getInstance()));
		ll.add(new Livro(1225, "um livro ruim 3", 89.99, 
				"autor bosta 3", "editora pior ainda 3", Calendar.getInstance()));
		
		for (Livro l : ll) {
			System.out.println("Livro: " + l.getAutor() + " " + l.getCodigo() + " " + l.getEditora() + " " + 
					l.getPreco() + " " + l.getTitulo() + " " + formata.format(l.getDataLancamento().getTime()));
		}

	}

}
