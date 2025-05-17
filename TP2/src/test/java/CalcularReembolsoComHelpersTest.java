import helpers.ConsultaTestHelper;
import org.*;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class CalcularReembolsoComHelpersTest {
    private CalculadoraReembolso service;
    private Auditoria auditoriaMock;
    private AutorizadorReembolso autorizadorMock;
    private Paciente dummyPaciente;

    @BeforeEach
    public void setup() {
        auditoriaMock = mock(Auditoria.class);
        autorizadorMock = mock(AutorizadorReembolso.class);
        when(autorizadorMock.autorizar(any(), any())).thenReturn(true);

        service = new CalculadoraReembolso(auditoriaMock, autorizadorMock);
        dummyPaciente = new Paciente();
    }

    @Test
    @DisplayName("Exercício 9 - Cálculo de reembolso básico")
    public void deveCalcularReembolsoCorretamente() {
        // Arrange
        Consulta consulta = ConsultaTestHelper.criarConsulta(0);
        PlanoSaudeStub plano = new PlanoSaudeStub(70);

        double reembolso = service.calcular(consulta, dummyPaciente, plano);

        assertEquals(0.0, reembolso, 0.001);
    }

    @Test
    @DisplayName("Exercício 9 - Cobertura com valor 0")
    public void testDeveRetornarZeroQuandoCoberturaZero() {
        // Consulta com valor 200
        Consulta consulta = ConsultaTestHelper.criarConsultaPadrao();
        PlanoSaudeStub plano = new PlanoSaudeStub(0);

        double reembolso = service.calcular(consulta, dummyPaciente, plano);

        assertEquals(0.0, reembolso, 0.01);
    }

    @Test
    @DisplayName("Exercício 9 - Cobertura com valor 100")
    public void testDeveRetornarValorInteiroQuandoCoberturaCem() {
        // Arrange
        Consulta consulta = ConsultaTestHelper.criarConsultaPadrao(); // Consulta com valor 200
        PlanoSaudeStub plano = new PlanoSaudeStub(100); // Plano com 100% de cobertura

        double reembolso = service.calcular(consulta, dummyPaciente, plano);

        assertEquals(200.0, reembolso, 0.01);
    }
}