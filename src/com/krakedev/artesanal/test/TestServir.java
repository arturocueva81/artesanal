package com.krakedev.artesanal.test;

import com.krakedev.artesanal.Maquina;

public class TestServir {

	public static void main(String[] args) {
		
		Maquina rubia=new Maquina(
				"PILSENER", 
				"Cerveza fria", 
				0.02, 
				8000);
		System.out.println("Estado Inicial");
		rubia.imprimir();
		System.out.println("Llenar maquina");
		rubia.llenarMaquina();
		rubia.imprimir();
		System.out.println("Servir 1000ml");
		double valor;
		valor=rubia.servirCerveza(1000);
		rubia.imprimir();
		System.out.println("Valor a pagar: "+valor);
		System.out.println("Servir 2000ml");
		
		valor=rubia.servirCerveza(2000);
		rubia.imprimir();
		System.out.println("Valor a pagar: "+valor);
		
		System.out.println("Servir 6000ml");
		
		valor=rubia.servirCerveza(6000);
		rubia.imprimir();
		System.out.println("Valor a pagar: "+valor);

	}

}
