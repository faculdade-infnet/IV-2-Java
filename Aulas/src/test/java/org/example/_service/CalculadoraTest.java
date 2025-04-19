package org.example._service;

import org.example._serviceTeste.Calculadora;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalculadoraTest {
    /**
     * Estrutura de teste
     */
    @Test
    void nomeDoTeste(){
        // ARRANGE

        // ACT


        // ASSERT

        // CLEANUP (se necessário)
    }


    /**
     * Soma dois números
     * @ Return = resultado da soma
     */
    @Test
    void somarDoisNumerosPositivoENegativo_ReturnSoma(){
        // ARRANGE
        var calculadora = new Calculadora();
        int valorNegativo = -5;
        int valorPositivo = 10;
        int expecteed = 5;

        // ACT - executar a ação/método que será testado
        int resultado = calculadora.somar(valorNegativo, valorPositivo);

        // ASSERT - verificar se o resultado está correto
        Assertions.assertEquals(expecteed, resultado);

        // CLEANUP - opcional en testes unitários
        // fechar conexões, limpar arquivos....
    }

    /**
     * Soma dois números
     * @ Return = resultado da soma
     */
    @Test
    void somarDoisNumeros_ReturnSoma(){
        var calculadora = new Calculadora();
        var actual = calculadora.somar(5, 4);

        Assertions.assertEquals(9, actual);
    }

    /**
     * Soma dois números negativos
     * @ Return = true
     */
    @Test
    void somarDoisNumerosNegativos_ReturnSomaNegativa(){
        var calculadora = new Calculadora();
        var actual = calculadora.somar(-6, -4);

        Assertions.assertEquals(-10, actual);
    }

    /**
     * Soma dois números com erro
     * @ Return = true = 0
     */
    @Test
    void somarDoisNumeros_ReturnZero(){
        var calculadora = new Calculadora();
        var actual = calculadora.somar(0, 0);

        Assertions.assertEquals(1, actual, "A soma deveria ser zero");
    }

    /**
     * Divisão por zero
     * @ return = exception
     */
    @Test
    void dividirPorZero_ReturnExcessao(){
        var calculadora = new Calculadora();
        var expected = calculadora.dividir(10, 0);

        Assertions.assertEquals(0, expected);
    }
}