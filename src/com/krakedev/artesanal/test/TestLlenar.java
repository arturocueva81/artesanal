package com.krakedev.artesanal.test;

import com.krakedev.artesanal.Maquina;

public class TestLlenar {

	public static void main(String[] args) {
		
		//ejercicio 1, parte 3: actualizar los test
		Maquina rubia=new Maquina(
				"M01",
				"PILSENER", 
				"Cerveza fria", 
				0.02, 
				8000);
		rubia.imprimir();
		rubia.llenarMaquina();
		rubia.imprimir();
		
		Maquina negra=new Maquina(
				"M02",
				"Club", 
				"Otra Cerveza", 
				0.03);
		negra.imprimir();
		negra.llenarMaquina();
		negra.imprimir();
	}

}
