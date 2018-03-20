package br.com.fiap.principal;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import br.com.fiap.bean.Livro;
import br.com.fiap.bean.Tablet;

public class Main {

	public static void main(String[] args) {
		SimpleDateFormat formata = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		
		Livro l = new Livro(1223, "um livro ruim", 87.99, 
				"autor bosta", "editora pior ainda", Calendar.getInstance());
		//Tablet(int codigo, String titulo, double preco, 
		//String modelo, String marca, String so, boolean tem3g) {
		Tablet t = new Tablet(66, "um tablet bom", 2000.00, "ipad", "apple", "ios", true);
		
		System.out.println("Tablet: " + t.getCodigo() + " " + t.getMarca() + " " + t.getModelo() + " "
				+ t.getPreco() + " " + t.getSo() +  " " + t.getTitulo() + " " + t.isTem3g());
		System.out.println("Livro: " + l.getAutor() + " " + l.getCodigo() + " " + l.getEditora() + " " + 
				l.getPreco() + " " + l.getTitulo() + " " + formata.format(l.getDataLancamento().getTime()));
	
		System.out.println("Garantia: " + t.calcularValorGarantiaEst(t.getPreco()));
	}

}
