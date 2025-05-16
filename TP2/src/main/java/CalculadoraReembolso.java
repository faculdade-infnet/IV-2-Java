public class CalculadoraReembolso {
    public double calcular(double valorConsulta, double percentualCobertura) {
        return valorConsulta * (percentualCobertura / 100);
    }

    public double calcular(double valorConsulta, double percentualCobertura, Paciente paciente) {
        return valorConsulta * (percentualCobertura / 100);
    }

    public double calcular(double valorConsulta, PlanoSaude plano) {
        return valorConsulta * (plano.getPercentualCobertura() / 100);
    }
}
