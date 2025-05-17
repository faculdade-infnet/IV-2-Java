package org;

public class Paciente {
    private String nome;

    public Paciente() {
    }

    public Paciente(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (!(o instanceof org.Paciente)) return false;
//        org.Paciente paciente = (org.Paciente) o;
//        return Objects.equals(nome, paciente.nome);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(nome);
//    }
}
