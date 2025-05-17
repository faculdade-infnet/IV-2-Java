public class Consulta {
    //    private final Paciente paciente;
    private final double valor;
//    private final double percentual;

    public Consulta(Paciente paciente, double valor, double percentualCobertura) {
//        this.paciente = paciente;
        this.valor = valor;
//        this.percentual = percentualCobertura;
    }

    public Consulta(double valor) {
        this.valor = valor;
    }

//    public Paciente getPaciente() {
//        return paciente;
//    }

    public double getValor() {
        return valor;
    }

//    public double getPercentualCobertura() {
//        return percentual;
//    }
}
