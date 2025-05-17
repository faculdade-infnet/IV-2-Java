import org.*;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class AuditoriaSpyTest {
    @Test
    @DisplayName("Exercício 07")
    public void testDeveChamarAuditoriaAoRegistrarConsulta() {
        AuditoriaSpy auditoriaSpy = new AuditoriaSpy();
        CalculadoraReembolso service = new CalculadoraReembolso(auditoriaSpy);
        Consulta consulta = new Consulta(200.0);
        Paciente paciente = new Paciente();
        PlanoSaudeStub plano = new PlanoSaudeStub();

        service.calcular(consulta, paciente, plano);

        assertTrue(auditoriaSpy.foiChamado(), "Esperado que o método registrarConsulta tenha sido chamado.");
    }
}