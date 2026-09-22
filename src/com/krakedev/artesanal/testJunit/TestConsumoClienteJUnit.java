package com.krakedev.artesanal.testJunit;

import org.junit.jupiter.api.Test;
import com.krakedev.artesanal.Cliente;
import com.krakedev.artesanal.Maquina;
import com.krakedev.artesanal.NegocioMejorado;
import static org.junit.jupiter.api.Assertions.*;

public class TestConsumoClienteJUnit {
	
	// ─────────────────────────────────────────────
    // TEST 1: Verificar que el totalConsumido del cliente se actualiza
    // Resultado esperado: totalConsumido = 300 * 0.85 = 255.0
    // ─────────────────────────────────────────────
    @Test
    public void testConsumirCerveza_clienteActualizado() {
        NegocioMejorado negocio = new NegocioMejorado();

        negocio.getMaquinas().add(new Maquina("M-10", "IPA Tropical", "Cerveza tropical", 0.85));
        negocio.cargarMaquinas();
        negocio.registrarCliente("Juan Pérez", "1234567890");

        Cliente cliente = negocio.buscarClientePorCedula("1234567890");
        negocio.consumirCerveza(cliente.getCodigo(), "M-10", 300);

        assertEquals(255.0, cliente.getTotalConsumido(), 0.01,
                "El totalConsumido del cliente debe ser 255.0");
    }

    // ─────────────────────────────────────────────
    // TEST 2: Verificar que la cantidadActual de la máquina disminuye
    // Resultado esperado: cantidadActual = 800 - 300 = 500.0
    // ─────────────────────────────────────────────
    @Test
    public void testConsumirCerveza_maquinaAfectada() {
        NegocioMejorado negocio = new NegocioMejorado();

        negocio.getMaquinas().add(new Maquina("M-10", "IPA Tropical", "Cerveza tropical", 0.85));
        negocio.cargarMaquinas();
        negocio.registrarCliente("Juan Pérez", "1234567890");

        Cliente cliente = negocio.buscarClientePorCedula("1234567890");
        negocio.consumirCerveza(cliente.getCodigo(), "M-10", 300);

        Maquina maquina = negocio.recuperarMaquina("M-10");
        assertEquals(500.0, maquina.getCantidadActual(), 0.01,
                "La cantidadActual de la máquina debe ser 500.0 después de servir 300 ml");
    }

    // ─────────────────────────────────────────────
    // TEST 3: Verificar que el consumo se acumula correctamente
    // Resultado esperado: totalConsumido = (300 * 0.85) + (200 * 0.85) = 425.0
    // ─────────────────────────────────────────────
    @Test
    public void testConsumirCerveza_acumulacionCorrecta() {
        NegocioMejorado negocio = new NegocioMejorado();

        negocio.getMaquinas().add(new Maquina("M-10", "IPA Tropical", "Cerveza tropical", 0.85));
        negocio.cargarMaquinas();
        negocio.registrarCliente("Juan Pérez", "1234567890");

        Cliente cliente = negocio.buscarClientePorCedula("1234567890");
        negocio.consumirCerveza(cliente.getCodigo(), "M-10", 300);
        negocio.consumirCerveza(cliente.getCodigo(), "M-10", 200);

        assertEquals(425.0, cliente.getTotalConsumido(), 0.01,
                "El totalConsumido acumulado debe ser 425.0");
    }

    // ─────────────────────────────────────────────
    // TEST 4: Verificar que si no hay suficiente cerveza retorna 0
    // Resultado esperado: totalConsumido del cliente sigue en 0.0
    // ─────────────────────────────────────────────
    @Test
    public void testConsumirCerveza_sinStockSuficiente_clienteNoActualiza() {
        NegocioMejorado negocio = new NegocioMejorado();

        negocio.getMaquinas().add(new Maquina("M-10", "IPA Tropical", "Cerveza tropical", 0.85));
        negocio.cargarMaquinas(); // cantidadActual = 800
        negocio.registrarCliente("Juan Pérez", "1234567890");

        Cliente cliente = negocio.buscarClientePorCedula("1234567890");

        // Intentar servir más de lo disponible
        negocio.consumirCerveza(cliente.getCodigo(), "M-10", 1000);

        assertEquals(0.0, cliente.getTotalConsumido(), 0.01,
                "El totalConsumido debe seguir en 0.0 si no hay stock suficiente");
    }

}
