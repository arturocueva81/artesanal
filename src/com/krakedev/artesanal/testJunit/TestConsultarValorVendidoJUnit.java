package com.krakedev.artesanal.testJunit;

import org.junit.jupiter.api.Test;
import com.krakedev.artesanal.Cliente;
import com.krakedev.artesanal.Maquina;
import com.krakedev.artesanal.NegocioMejorado;
import static org.junit.jupiter.api.Assertions.*;

public class TestConsultarValorVendidoJUnit {

    // ─────────────────────────────────────────────
    // TEST 1: Sin consumos, el total vendido debe ser 0
    // Resultado esperado: 0.0
    // ─────────────────────────────────────────────
    @Test
    public void testConsultarValorVendido_sinConsumos_debeSer0() {
        NegocioMejorado negocio = new NegocioMejorado();
        negocio.registrarCliente("Juan Pérez", "1234567890");
        negocio.registrarCliente("María López", "0987654321");

        double total = negocio.consultarValorVendido();

        assertEquals(0.0, total, 0.01,
                "Sin consumos el total vendido debe ser 0.0");
    }

    // ─────────────────────────────────────────────
    // TEST 2: Un solo cliente consume, verificar total
    // Resultado esperado: 300 * 0.85 = 255.0
    // ─────────────────────────────────────────────
    @Test
    public void testConsultarValorVendido_unCliente_debeRetornarSuConsumo() {
        NegocioMejorado negocio = new NegocioMejorado();

        negocio.getMaquinas().add(new Maquina("M-10", "IPA Tropical", "Cerveza tropical", 0.85));
        negocio.cargarMaquinas();
        negocio.registrarCliente("Juan Pérez", "1234567890");

        Cliente cliente = negocio.buscarClientePorCedula("1234567890");
        negocio.consumirCerveza(cliente.getCodigo(), "M-10", 300);

        double total = negocio.consultarValorVendido();

        assertEquals(255.0, total, 0.01,
                "El total vendido debe ser 255.0");
    }

    // ─────────────────────────────────────────────
    // TEST 3: Varios clientes consumen, verificar suma total
    // Juan: 300 * 0.85 = 255.0
    // María: 200 * 0.85 = 170.0
    // Resultado esperado: 255.0 + 170.0 = 425.0
    // ─────────────────────────────────────────────
    @Test
    public void testConsultarValorVendido_variosClientes_debeSumarTodos() {
        NegocioMejorado negocio = new NegocioMejorado();

        negocio.getMaquinas().add(new Maquina("M-10", "IPA Tropical", "Cerveza tropical", 0.85));
        negocio.cargarMaquinas();

        negocio.registrarCliente("Juan Pérez", "1234567890");
        negocio.registrarCliente("María López", "0987654321");

        Cliente juan = negocio.buscarClientePorCedula("1234567890");
        Cliente maria = negocio.buscarClientePorCedula("0987654321");

        negocio.consumirCerveza(juan.getCodigo(), "M-10", 300);
        negocio.consumirCerveza(maria.getCodigo(), "M-10", 200);

        double total = negocio.consultarValorVendido();

        assertEquals(425.0, total, 0.01,
                "El total vendido de todos los clientes debe ser 425.0");
    }

    // ─────────────────────────────────────────────
    // TEST 4: Lista de clientes vacía, total debe ser 0
    // Resultado esperado: 0.0
    // ─────────────────────────────────────────────
    @Test
    public void testConsultarValorVendido_listaVacia_debeSer0() {
        NegocioMejorado negocio = new NegocioMejorado();

        double total = negocio.consultarValorVendido();

        assertEquals(0.0, total, 0.01,
                "Con lista vacía el total vendido debe ser 0.0");
    }
}