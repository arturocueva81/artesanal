package com.krakedev.artesanal.testNegocio;

import com.krakedev.artesanal.Cliente;
import com.krakedev.artesanal.NegocioMejorado;

public class TestBuscarClientePorCedula {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NegocioMejorado nm = new NegocioMejorado();
		nm.registrarCliente("Andres Arce", "1111111111");
		nm.registrarCliente("Bolivar Bueno", "2222222222");
		nm.registrarCliente("Carlos Castro", "3333333333");
		
		Cliente cl1=nm.buscarClientePorCedula("2222222222");
		
		if(cl1!=null) {
			System.out.println("Cliente encontrado");
			System.out.println("- Nombre: "+cl1.getNombre()+", Cedula: "+cl1.getCedula()+", Codigo: "+cl1.getCodigo());
		}else {
			System.out.println("La ceédula no está registrada");
		}
		
		Cliente cl2=nm.buscarClientePorCedula("0000000000");
		
		if(cl2 ==null) {
			System.out.println("La Cédula no fue encontrada por lo que el registro buscado es NULL");
		}

	}

}
