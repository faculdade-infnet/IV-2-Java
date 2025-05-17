import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class CalculadoraReembolsoMockitoTest {
    private AuditoriaSpy auditoriaSpy;
    private AutorizadorReembolso autorizadorMock;
    private Consulta consulta;
    private Paciente paciente;
    private PlanoSaudeBasico plano;

    // Setup
    @BeforeEach
    public void setUp() {
        auditoriaSpy = new AuditoriaSpy();
        autorizadorMock = mock(AutorizadorReembolso.class);
        consulta = new Consulta(200.0);
        paciente = new Paciente();
        plano = new PlanoSaudeBasico();
    }


    @Test
    @DisplayName("Exercício 08 - Nao autorizado")
    public void testDeveLancarExcecaoQuandoNaoAutorizado() {
        // Arrange
        Auditoria auditoriaMock = mock(Auditoria.class);
        HistoricoConsultas historicoMock = mock(HistoricoConsultas.class);
        AutorizadorReembolso autorizadorMock = mock(AutorizadorReembolso.class);

        when(autorizadorMock.autorizar(any(Consulta.class), any(Paciente.class))).thenReturn(false);
        CalculadoraReembolso service = new CalculadoraReembolso(auditoriaMock, autorizadorMock);

        double reembolso = service.calcular(consulta, paciente, plano);
        // O teste passa se a exceção ReembolsoNaoAutorizadoException for lançada
    }

    @Test
    @DisplayName("Exercício 08 - Autorizado")
    public void testDeveCalcularQuandoAutorizado() {
        // Arrange
        Auditoria auditoriaMock = mock(Auditoria.class);
        AutorizadorReembolso autorizadorMock = mock(AutorizadorReembolso.class);

        when(autorizadorMock.autorizar(any(Consulta.class), any(Paciente.class))).thenReturn(true);
        CalculadoraReembolso service = new CalculadoraReembolso(auditoriaMock, autorizadorMock);

        double reembolso = service.calcular(consulta, paciente, plano);

        assertEquals(140.0, reembolso, 0.001);
        verify(autorizadorMock).autorizar(consulta, paciente);
    }
}
