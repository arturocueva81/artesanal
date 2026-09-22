package com.krakedev.artesanal.testNegocio;

import com.krakedev.artesanal.Cliente;
import com.krakedev.artesanal.NegocioMejorado;

public class TestConsumirCerveza {

    public static void main(String[] args) {
        NegocioMejorado negocio = new NegocioMejorado();

        negocio.getMaquinas().add(new com.krakedev.artesanal.Maquina("M-10", "IPA Tropical", "Cerveza tropical", 0.85));
        negocio.cargarMaquinas();
        negocio.registrarCliente("Juan Pérez", "1234567890");

        Cliente cliente = negocio.buscarClientePorCedula("1234567890");
        int codigoCliente = cliente.getCodigo();

        System.out.println("ANTES del consumo");
        System.out.println("- Total consumido: $" + cliente.getTotalConsumido());
        System.out.println("- Cantidad en máquina "+negocio.getMaquinas().get(0).getCodigo() +" es:  " + negocio.getMaquinas().get(0).getCantidadActual() + " ml");

        negocio.consumirCerveza(codigoCliente, "M-10", 300);

        System.out.println("DESPUÉS de consumir 300 ml");
        System.out.println("- Total consumido: $" + cliente.getTotalConsumido());
        System.out.println("- Cantidad en máquina "+negocio.getMaquinas().get(0).getCodigo() +" es:  " + negocio.getMaquinas().get(0).getCantidadActual() + " ml");

        negocio.consumirCerveza(codigoCliente, "M-10", 200);

        System.out.println("DESPUÉS de consumir 200 ml más");
        System.out.println("- Total consumido: $" + cliente.getTotalConsumido());
        System.out.println("- Cantidad en la máquina "+negocio.getMaquinas().get(0).getCodigo() +" es:  "+ negocio.getMaquinas().get(0).getCantidadActual() + " ml");
    }
}