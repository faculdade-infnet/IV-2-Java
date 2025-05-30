package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import org.example.client.HTTPClient;
import java.io.IOException;
import java.net.URISyntaxException;

public class Exercicio01 {
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public static void main(String[] args) throws IOException, URISyntaxException {
        try {
            System.out.println("Exercicio 01");

            String[] respostaGet = HTTPClient.get("https://apichallenges.eviltester.com/sim/entities");

            System.out.println("Status Code: " + respostaGet[1]);
            System.out.println("Corpo da Resposta:");

            // Converte JSON  em objeto java
            JsonElement jsonElement = JsonParser.parseString(respostaGet[0]);
            // Converte o objeto para string formatada
            String jsonFormatado = gson.toJson(jsonElement);

            System.out.println(jsonFormatado);

        } catch (Exception e) {
            throw new RuntimeException((e));
        }
    }
}