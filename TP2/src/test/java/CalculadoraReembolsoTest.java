import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class CalculadoraReembolsoTest {
    private CalculadoraReembolso service;
    private Paciente dummyPaciente;

    // Setup
    @BeforeEach
    public void setUp() {
        service = new CalculadoraReembolso();
        dummyPaciente = new Paciente();
    }

    @Test
    @DisplayName("Exercício 01")
    public void testDeveRetornarValorOriginalComPercentualDeDesconto() {
        double actual = service.calcular(200, 70, dummyPaciente);

        assertEquals(140.0, actual, 0.01);
    }

    @Test
    @DisplayName("Exercício 02 - Consulta com valor 0")
    public void testDeveRetornarZeroQuandoConsultaZero() {
        double actual = service.calcular(0, 70, dummyPaciente);

        assertEquals(0.0, actual, 0.01);
    }

    @Test
    @DisplayName("Exercício 02 - Cobertura com valor 0")
    public void testDeveRetornarZeroQuandoCoberturaZero() {
        double actual = service.calcular(200, 0, dummyPaciente);

        assertEquals(0.0, actual, 0.01);
    }

    @Test
    @DisplayName("Exercício 02 - Cobertura com valor 100")
    public void testDeveRetornarValorInteiroQuandoCoberturaCem() {
        double actual = service.calcular(200, 100, dummyPaciente);

        assertEquals(200.0, actual, 0.01);
    }
}