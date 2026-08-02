package com.krakedev.artesanal.testJunit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.krakedev.artesanal.Maquina;

public class TestLlenarJUnit {
	@Test
	
	//ejercicio 1. Ejecutar pruebas unitarias
	public void testLlenarMaquina() {
		Maquina rubia=new Maquina("m01","pilsener","cerveza", 0.02, 8000);
		rubia.llenarMaquina();
		
		assertEquals(7800,rubia.getCantidadActual(),0.0001);//ejercicio 2
		
	}

}
