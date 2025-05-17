package org;

public class Consulta {
    //    private final org.Paciente paciente;
    private double valor;
//    private final double percentual;

    public Consulta(Paciente paciente, double valor, double percentualCobertura) {
//        this.paciente = paciente;
        this.valor = valor;
//        this.percentual = percentualCobertura;
    }

    public static Consulta criarConsultaCompleta(Paciente paciente, double valor, double percentualCobertura) {
        return new Consulta(paciente, valor, percentualCobertura);
    }

    public Consulta(double valor) {
        this.valor = valor;
    }


    public double getValor() {
        return valor;
    }
//    public org.Paciente getPaciente() {
//        return paciente;
//    }

//    public double getPercentualCobertura() {
//        return percentual;
//    }
}
