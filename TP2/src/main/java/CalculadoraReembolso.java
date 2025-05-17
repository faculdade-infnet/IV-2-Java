public class CalculadoraReembolso {
    //    public double calcular(double valorConsulta, double percentualCobertura) {
    //        return valorConsulta * (percentualCobertura / 100);
    //    }

    //    public double calcular(double valorConsulta, double percentualCobertura, Paciente paciente) {
    //        return valorConsulta * (percentualCobertura / 100);
    //    }
    private Auditoria auditoria;

    public CalculadoraReembolso() {
    }

    public CalculadoraReembolso(Auditoria auditoria) {
        this.auditoria = auditoria;
    }

    public double calcular(double valorConsulta, PlanoSaude plano) {
        return valorConsulta * (plano.getPercentualCobertura() / 100);
    }

    public double calcular(double valorConsulta, double percentualCobertura, Paciente paciente) {
        double reembolso = valorConsulta * (percentualCobertura / 100);

        // Define o valor de auditoria como TRUE, garantindo que ele foi chamado
        auditoria.registrarConsulta(paciente, reembolso);
        return reembolso;
    }
}
