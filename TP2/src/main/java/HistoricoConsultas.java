import java.util.List;

public interface HistoricoConsultas {
    void adicionarConsulta(Paciente paciente, double valor, double percentual);

    List<Consulta> listarConsultas();
}
