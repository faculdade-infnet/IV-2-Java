package org.example;

import com.google.gson.Gson;
import org.example.client.HTTPClient;

import java.io.IOException;
import java.net.URISyntaxException;

public class Exercicio11 {
    private static final Gson gson = new Gson();

    public static void main(String[] args) throws IOException, URISyntaxException {
        try {
            System.out.println("Exercicio 11");

            String[] respostaOptions = HTTPClient.options("https://apichallenges.eviltester.com/sim/entities");

            System.out.println("Status Code: " + respostaOptions[1] );
            System.out.println("Métodos permitidos no cabecalho Allow: " + respostaOptions[0]);

        } catch (Exception e) {
            throw new RuntimeException((e));
        }
    }
}