public class Consulta {
    private final Paciente paciente;
    private final double valor;
    private final double percentual;

    public Consulta(Paciente paciente, double valor, double percentual) {
        this.paciente = paciente;
        this.valor = valor;
        this.percentual = percentual;
    }


    public Paciente getPaciente() {
        return paciente;
    }

    public double getValor() {
        return valor;
    }

    public double getPercentual() {
        return percentual;
    }
}
