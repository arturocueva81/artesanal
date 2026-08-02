package com.krakedev.artesanal.testJunit;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.krakedev.artesanal.Maquina;

public class TestRecargarJUnit {
	@Test
	
	//ejercicio 1. Ejecutar pruebas unitarias
	public void testRecargaExitosa() {
		Maquina rubia=new Maquina("m01", "pilsener","cerveza", 0.02, 8000);
		boolean resultado=rubia.recargarCerveza(3000);
		assertTrue(resultado);
		assertEquals(3000, rubia.getCantidadActual(),0.0001);
	}
	
	@Test
	public void testRecargaFallida() {
		Maquina negra=new Maquina("m02", "club","no es cerveza", 0.03, 8000);
		negra.recargarCerveza(7000);
		boolean resultado=negra.recargarCerveza(1000);
		assertFalse(resultado);
		assertEquals(7000, negra.getCantidadActual(),0.0001);
	}

}
