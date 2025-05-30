package org.example;

import com.google.gson.Gson;
import org.example.client.HTTPClient;
import org.example.get.GetRequest;

import java.io.IOException;
import java.net.URISyntaxException;

public class Exercicio04 {
    private static final Gson gson = new Gson();

    public static void main(String[] args) throws IOException, URISyntaxException {
        try {
            System.out.println("Exercicio 04");

            String url = "https://apichallenges.eviltester.com/sim/entities?categoria=teste&limite=5";
            String[] respostaGet = HTTPClient.get(url);

            System.out.println("URL Final: " + url);
            System.out.println("Status Code: " + respostaGet[1]);

        } catch (Exception e) {
            //System.out.println("Status Code: " + respostaGet[0]);
            throw new RuntimeException((e));
        }
    }
}
