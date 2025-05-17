package org;

public class CalculadoraReembolso {


    //    public double calcular(double valorConsulta, double percentualCobertura) {
    //        return valorConsulta * (percentualCobertura / 100);
    //    }

    public double calcular(double valorConsulta, double percentualCobertura, Paciente paciente) {
        return valorConsulta * (percentualCobertura / 100);
    }

    public CalculadoraReembolso() {
    }

    public CalculadoraReembolso(Auditoria auditoria) {
        this.auditoria = auditoria;
    }

    public double calcular(double valorConsulta, PlanoSaudeStub plano) {
        return valorConsulta * plano.getPercentualCobertura(70);
    }

    private Auditoria auditoria;
    private AutorizadorReembolso autorizador;

    public CalculadoraReembolso(Auditoria auditoria, AutorizadorReembolso autorizador) {
        this.auditoria = auditoria;
        this.autorizador = autorizador;
    }

    public double calcular(Consulta consulta, Paciente paciente, PlanoSaudeStub plano) {
        if (!autorizador.autorizar(consulta, paciente)) {
            try {
                throw new ReembolsoNaoAutorizadoException("Reembolso não autorizado");
            } catch (ReembolsoNaoAutorizadoException e) {
                throw new RuntimeException(e);
            }
        }

        double reembolso = consulta.getValor() * plano.getPercentualCobertura();

        // Define o valor de auditoria como TRUE, garantindo que ele foi chamado
        auditoria.registrarConsulta(consulta);
        return reembolso;
    }
}
