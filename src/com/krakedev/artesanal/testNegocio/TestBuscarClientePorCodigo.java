package com.krakedev.artesanal.testNegocio;

import com.krakedev.artesanal.Cliente;
import com.krakedev.artesanal.NegocioMejorado;

public class TestBuscarClientePorCodigo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NegocioMejorado negocio = new NegocioMejorado();

        negocio.registrarCliente("Juan Pérez", "1234567890");
        negocio.registrarCliente("María López", "0987654321");
        negocio.registrarCliente("Carlos Torres", "1122334455");

        System.out.println("=== Clientes registrados ===");
        for (int i = 0; i < negocio.getClientes().size(); i++) {
            Cliente c = negocio.getClientes().get(i);
            System.out.println("Código: " + c.getCodigo()
                    + " | Nombre: " + c.getNombre()
                    + ", Cédula: " + c.getCedula());
        }


        Cliente c1 = negocio.buscarClientePorCodigo(102);
        if (c1 != null) {
            System.out.println("\n Cliente encontrado: " + c1.getNombre()
                    + " , Código: " + c1.getCodigo());
        } else {
            System.out.println("\n Cliente no encontrado");
        }


        Cliente c2 = negocio.buscarClientePorCodigo(999);
        if (c2 == null) {
            System.out.println("Código no existe, retorna null correctamente");
        }
    }

}

