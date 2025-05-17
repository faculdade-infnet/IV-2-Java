package helpers;

import org.Consulta;

public class ConsultaTestHelper {
    public static Consulta criarConsultaPadrao() {
        return new Consulta(200.0);
    }

    public static Consulta criarConsulta(double valor) {
        return new Consulta(valor);
    }
}