package com.krakedev.artesanal.testNegocio;

import com.krakedev.artesanal.NegocioMejorado;

public class TestCargarMaquinas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NegocioMejorado negocioM= new NegocioMejorado();
		
		negocioM.agregarMaquina("Cerveza Blanca", "cerveza procesada", 1.50);
		negocioM.agregarMaquina("Cerveza Fuerte", "cerveza con minimo proceso", 1.00);

		System.out.println("MAQUINAS SIN CARGAR");
		for (int i=0;i<negocioM.getMaquinas().size();i++) {
			negocioM.getMaquinas().get(i).imprimir();
		}
		
		negocioM.cargarMaquinas();
		
		System.out.println("MAQUINAS CARGADS");
		for (int i=0;i<negocioM.getMaquinas().size();i++) {
			negocioM.getMaquinas().get(i).imprimir();
		}
	}

}
