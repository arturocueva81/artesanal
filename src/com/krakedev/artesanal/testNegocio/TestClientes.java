package com.krakedev.artesanal.testNegocio;

import com.krakedev.artesanal.NegocioMejorado;

public class TestClientes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NegocioMejorado negocio = new NegocioMejorado();
		
		negocio.registrarCliente("Arturo Cueva", "0123456789");
		negocio.registrarCliente("María López", "0987654321");
		
		//12. validar funcionamiento
		System.out.println(" Clientes Registtrados: " + negocio.getClientes().size());

	}

}
