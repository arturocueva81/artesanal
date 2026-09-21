package com.krakedev.artesanal.testJunit;

import org.junit.jupiter.api.Test;
import com.krakedev.artesanal.Maquina;
import com.krakedev.artesanal.NegocioMejorado;
import static org.junit.jupiter.api.Assertions.*;

public class TestRecuperarMaquinaJUNIT {
	
	// ─────────────────────────────────────────────
    // TEST 1: Recuperar una máquina que SÍ existe
    // Resultado esperado: retorna el objeto Maquina (no null)
    // ─────────────────────────────────────────────
    @Test
    public void testRecuperarMaquina_existente_debeRetornarMaquina() {
        NegocioMejorado negocio = new NegocioMejorado();

        // Agregamos manualmente con código conocido
        Maquina maquina = new Maquina("M-10", "IPA Tropical", "Cerveza tropical", 0.85);
        negocio.getMaquinas().add(maquina);

        Maquina resultado = negocio.recuperarMaquina("M-10");

        assertNotNull(resultado, "Debe retornar la maquina cuando el código existe");
        assertEquals("M-10", resultado.getCodigo(), "El código debe ser M-10");
    }

    // ─────────────────────────────────────────────
    // TEST 2: Recuperar una máquina que NO existe
    // Resultado esperado: retorna null
    // ─────────────────────────────────────────────
    @Test
    public void testRecuperarMaquina_noExistente_debeRetornarNull() {
        NegocioMejorado negocio = new NegocioMejorado();

        Maquina maquina = new Maquina("M-10", "IPA Tropical", "Cerveza tropical", 0.85);
        negocio.getMaquinas().add(maquina);

        Maquina resultado = negocio.recuperarMaquina("M-99");

        assertNull(resultado, "Debe retornar null cuando el código no existe");
    }

    // ─────────────────────────────────────────────
    // TEST 3: Recuperar de una lista vacía
    // Resultado esperado: retorna null
    // ─────────────────────────────────────────────
    @Test
    public void testRecuperarMaquina_listaVacia_debeRetornarNull() {
        NegocioMejorado negocio = new NegocioMejorado();

        Maquina resultado = negocio.recuperarMaquina("M-10");

        assertNull(resultado, "Debe retornar null cuando la lista está vacía");
    }

}
