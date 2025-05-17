import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StubPlanoSaudeTest {
    private CalculadoraReembolso service;

    // Setup
    @BeforeEach
    public void setUp() {
        service = new CalculadoraReembolso();
    }

    @Test
    @DisplayName("Exercício 06 - Stub - Plano com 50% de cobertura")
    void testPlano50Porcento() {
        PlanoSaude planoStub = () -> 50.0;  // Stub como lambda
        double resultado = service.calcular(200, planoStub);
        assertEquals(100.0, resultado, 0.01);
    }

    @Test
    @DisplayName("Exercício 06 - Stub - Plano com 80% de cobertura")
    void testPlanoComOitentaPorcento() {
        PlanoSaude planoStub = () -> 80.0;
        double resultado = service.calcular(200, planoStub);
        assertEquals(160.0, resultado, 0.01);
    }
}