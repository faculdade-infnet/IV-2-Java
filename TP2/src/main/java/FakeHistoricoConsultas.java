import java.util.*;

public class FakeHistoricoConsultas implements HistoricoConsultas {
    private final List<Consulta> historicoConsultas = new ArrayList<>();

    @Override
    public void adicionarConsulta(Paciente paciente, double valor, double percentual) {
        historicoConsultas.add(new Consulta(paciente, valor, percentual));
    }

    @Override
    public List<Consulta> listarConsultas() {
        return new ArrayList<>(historicoConsultas);
    }
}
