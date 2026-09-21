package com.krakedev.artesanal.testNegocio;

import com.krakedev.artesanal.NegocioMejorado;

public class TestAgregarMaquina {

    public static void main(String[] args) {
        NegocioMejorado negocio = new NegocioMejorado();

        negocio.agregarMaquina("Cerveza01", "Cerveza popular", 0.85);
        negocio.agregarMaquina("Cerveza02", "Cerveza negra intensa", 1.20);
        negocio.agregarMaquina("Cerveza03", "Cerveza rubia suave", 0.75);

        System.out.println("Total maquinas: " + negocio.getMaquinas().size());

        for (int i = 0; i < negocio.getMaquinas().size(); i++) {
            negocio.getMaquinas().get(i).imprimir();
        }
    }
}