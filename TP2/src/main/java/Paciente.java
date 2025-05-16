import java.util.Objects;

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
//        if (!(o instanceof Paciente)) return false;
//        Paciente paciente = (Paciente) o;
//        return Objects.equals(nome, paciente.nome);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(nome);
//    }
}
