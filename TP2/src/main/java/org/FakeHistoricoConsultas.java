package org;

import java.util.*;

public class FakeHistoricoConsultas implements HistoricoConsultas {
    private final List<Consulta> historicoConsultas = new ArrayList<>();

    @Override
    public void adicionarConsulta(Consulta consulta) {
        historicoConsultas.add(consulta);
    }

    @Override
    public List<Consulta> listarConsultas() {
        return new ArrayList<>(historicoConsultas);
    }
}
