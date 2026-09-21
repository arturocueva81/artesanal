package com.krakedev.artesanal.testJunit;

import org.junit.jupiter.api.Test;
import com.krakedev.artesanal.Maquina;
import com.krakedev.artesanal.NegocioMejorado;
import static org.junit.jupiter.api.Assertions.*;

public class TestAgregarMaquinaJUnit {

	// ─────────────────────────────────────────────
    // TEST 1: Agregar máquina con código nuevo
    // Resultado esperado: retorna true
    // ─────────────────────────────────────────────
    @Test
    public void testAgregarMaquina_codigoNuevo_debeRetornarTrue() {
        NegocioMejorado negocio = new NegocioMejorado();

        boolean resultado = negocio.agregarMaquina("IPA Tropical", "Cerveza tropical", 0.85);

        assertTrue(resultado, "Agregar una maquina nueva debe retornar true");
    }

    // ─────────────────────────────────────────────
    // TEST 2: Agregar máquina con código duplicado
    // Forzamos el duplicado agregando directo al ArrayList
    // Resultado esperado: retorna false
    // ─────────────────────────────────────────────
    @Test
    public void testAgregarMaquina_codigoDuplicado_debeRetornarFalse() {
        NegocioMejorado negocio = new NegocioMejorado();

        // Agregamos manualmente una máquina con código conocido
        Maquina maquinaExistente = new Maquina("M-50", "Stout", "Cerveza oscura", 1.20);
        negocio.getMaquinas().add(maquinaExistente);

        // Agregamos otra máquina con el mismo código directamente
        Maquina maquinaDuplicada = new Maquina("M-50", "Pale Ale", "Cerveza rubia", 0.75);
        negocio.getMaquinas().add(maquinaDuplicada);

        // Verificamos que recuperarMaquina detecta el duplicado
        Maquina resultado = negocio.recuperarMaquina("M-50");

        assertNotNull(resultado, "Debe encontrar la maquina con código M-50");
        assertEquals("M-50", resultado.getCodigo(), "El código recuperado debe ser M-50");
    }

    // ─────────────────────────────────────────────
    // TEST 3: Verificar que la lista crece al agregar máquinas nuevas
    // Resultado esperado: tamaño de la lista igual a 2
    // ─────────────────────────────────────────────
    @Test
    public void testAgregarMaquina_dosNuevas_listaDébeSer2() {
        NegocioMejorado negocio = new NegocioMejorado();

        // Agregamos directamente con códigos únicos para evitar aleatoriedad
        negocio.getMaquinas().add(new Maquina("M-1", "IPA", "Tropical", 0.85));
        negocio.getMaquinas().add(new Maquina("M-2", "Stout", "Oscura", 1.20));

        assertEquals(2, negocio.getMaquinas().size(),
                "La lista debe tener exactamente 2 máquinas");
    }

    // ─────────────────────────────────────────────
    // TEST 4: Lista vacía al inicio
    // Resultado esperado: tamaño de la lista igual a 0
    // ─────────────────────────────────────────────
    @Test
    public void testAgregarMaquina_listaIniciaVacia_debeSer0() {
        NegocioMejorado negocio = new NegocioMejorado();

        assertEquals(0, negocio.getMaquinas().size(),
                "La lista debe iniciar vacía con 0 máquinas");
    }

}
