public class ReembolsoService {
    public double calcularReembolso(double valorConsulta, double percentualCobertura) {
        return valorConsulta * (percentualCobertura / 100);
    }
}
