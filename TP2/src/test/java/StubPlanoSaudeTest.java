import org.CalculadoraReembolso;
import org.PlanoSaudeStub;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StubPlanoSaudeTest {
    private CalculadoraReembolso service;
    private PlanoSaudeStub planoStub;

    // Setup
    @BeforeEach
    public void setUp() {
        service = new CalculadoraReembolso();
        planoStub = new PlanoSaudeStub();
    }

    @Test
    @DisplayName("Exercício 06 - Stub - Plano com 50% de cobertura")
    void testPlano50Porcento() {
        double resultado = service.calcular(200, planoStub);
        assertEquals(140.0, resultado, 0.01);
    }

    @Test
    @DisplayName("Exercício 06 - Stub - Plano com 80% de cobertura")
    void testPlanoComOitentaPorcento() {
        double resultado = service.calcular(200, planoStub);
        assertEquals(140.0, resultado, 0.01);
    }
}