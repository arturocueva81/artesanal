package com.krakedev.artesanal.testNegocio;

import com.krakedev.artesanal.NegocioMejorado;

public class TestClientes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NegocioMejorado negocio = new NegocioMejorado();
		
		negocio.registrarCliente("Arturo Cueva", "0123456789");
		System.out.println("El cliente ha sido registrado");

	}

}
