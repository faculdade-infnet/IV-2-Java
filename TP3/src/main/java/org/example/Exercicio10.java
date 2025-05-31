package org.example;

import com.google.gson.Gson;
import org.example.client.HTTPClient;

import java.io.IOException;
import java.net.URISyntaxException;

public class Exercicio10 {
    private static final Gson gson = new Gson();

    public static void main(String[] args) throws IOException, URISyntaxException {
        try {
            System.out.println("Exercicio 10");

            String[] respostaDelete = HTTPClient.delete("https://apichallenges.eviltester.com/sim/entities/2");
            System.out.println("Status Code: " + respostaDelete[1] + " " + respostaDelete[2]);

        } catch (Exception e) {
            throw new RuntimeException((e));
        }
    }
}