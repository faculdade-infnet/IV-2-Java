package org.example;

import com.google.gson.Gson;
import org.example.client.HTTPClient;
import org.example.get.GetRequest;

import java.io.IOException;
import java.net.URISyntaxException;

public class Exercicio02 {
    private static final Gson gson = new Gson();

    public static void main(String[] args) throws IOException, URISyntaxException {
        try {
            System.out.println("Exercicio 02");

            for (int i = 2; i <=8; i++) {
                String[] respostaGet = HTTPClient.get("https://apichallenges.eviltester.com/sim/entities/" + i);
                GetRequest request = gson.fromJson(respostaGet[0], GetRequest.class);

                System.out.println("Status Code: " + respostaGet[1]);
                System.out.println("{\n" +
                        "  id: " + request.id() + ",\n" +
                        "  name: \"" + request.name() + "\",\n" +
                        "  description: \"" + request.description() + "\"\n" +
                        "}");
            }

        } catch (Exception e) {
            throw new RuntimeException((e));
        }
    }
}