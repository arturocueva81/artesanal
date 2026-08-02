package com.krakedev.artesanal.test;

import com.krakedev.artesanal.Maquina;

public class TestAtributos {

	public static void main(String[] args) {
		
		//ejercicio 1, parte 3: actualizar los test
		Maquina rubia=new Maquina(
				"M01",
				"Pilsener",
				"cerveza rubia", 
				0.02,
				1000);
		rubia.imprimir();
	}

}
