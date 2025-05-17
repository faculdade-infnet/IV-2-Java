public class AuditoriaSpy implements Auditoria {
    private boolean foiChamado = false;

    @Override
    public void registrarConsulta(Paciente paciente, double valor) {
        foiChamado = true;
    }

    public boolean foiChamado() {
        return foiChamado;
    }
}
