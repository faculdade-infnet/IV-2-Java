import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class AuditoriaSpyTest {
    @Test
    @DisplayName("Exercício 07")
    public void testDeveChamarAuditoriaAoRegistrarConsulta() {
        AuditoriaSpy auditoriaSpy = new AuditoriaSpy();
        CalculadoraReembolso service = new CalculadoraReembolso(auditoriaSpy);
        Paciente pacienteDummy = new Paciente();

        service.calcular(100, 50, pacienteDummy);

        assertTrue(auditoriaSpy.foiChamado(), "Esperado que o método registrarConsulta tenha sido chamado.");
    }
}