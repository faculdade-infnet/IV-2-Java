package org.example;

import com.google.gson.Gson;
import org.example.client.HTTPClient;
import org.example.get.GetRequest;

import java.io.IOException;
import java.net.URISyntaxException;

public class Exercicio09 {
    private static final Gson gson = new Gson();

    public static void main(String[] args) throws IOException, URISyntaxException {
        try {
            System.out.println("Exercicio 09");

            String[] respostaDelete = HTTPClient.delete("https://apichallenges.eviltester.com/sim/entities/9");
            System.out.println("Status Code: " + respostaDelete[1] + " " + respostaDelete[2]);

            // Tenta fazer GET para confirmar se entidade foi deletada
            String[] respostaGet = HTTPClient.get("https://apichallenges.eviltester.com/sim/entities/9");
            System.out.println("Status Code GET apos DELETE: " + respostaGet[1]);

            if ("404".equals(respostaGet[1])) {
                System.out.println("Confirmação: Entidade nao encontrada (404). DELETE realizado com sucesso.");
            } else {
                System.out.println("Entidade ainda existe:");
                System.out.println(respostaGet[0]);
            }
        } catch (Exception e) {
            throw new RuntimeException((e));
        }
    }
}