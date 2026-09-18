package com.krakedev.artesanal.testJunit;

import org.junit.jupiter.api.Test;
import com.krakedev.artesanal.NegocioMejorado;
import static org.junit.jupiter.api.Assertions.*;

public class TestGenerarCodigo {
	
	// ─────────────────────────────────────────────
    // TEST 1: Verificar que el código empieza con "M-"
    // Resultado esperado: el código generado inicia con "M-"
    // ─────────────────────────────────────────────
    @Test
    public void testGenerarCodigo_debeEmpezarConM() {
        NegocioMejorado negocio = new NegocioMejorado();
        String codigo = negocio.generarCodigo();
        assertTrue(codigo.startsWith("M-"), 
            "El código debe empezar con 'M-'");
    }

    // ─────────────────────────────────────────────
    // TEST 2: Verificar que el número está entre 1 y 100
    // Resultado esperado: la parte numérica es >= 1 y <= 100
    // ─────────────────────────────────────────────
    @Test
    public void testGenerarCodigo_numeroDebeEstarEntre1y100() {
        NegocioMejorado negocio = new NegocioMejorado();
        String codigo = negocio.generarCodigo();

        // Extrae la parte numérica después de "M-"
        int numero = Integer.parseInt(codigo.substring(2));

        assertTrue(numero >= 1 && numero <= 100, 
            "El número debe estar entre 1 y 100, fue: " + numero);
    }

    // ─────────────────────────────────────────────
    // TEST 3: Verificar que el código no es null ni vacío
    // Resultado esperado: el código tiene contenido válido
    // ─────────────────────────────────────────────
    @Test
    public void testGenerarCodigo_noDebeSerNullNiVacio() {
        NegocioMejorado negocio = new NegocioMejorado();
        String codigo = negocio.generarCodigo();

        assertNotNull(codigo, "El código no debe ser null");
        assertFalse(codigo.isEmpty(), "El código no debe estar vacío");
    }

}
