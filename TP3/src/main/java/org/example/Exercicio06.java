package org.example;

import com.google.gson.Gson;
import org.example.client.HTTPClient;
import org.example.get.GetRequest;

import java.io.IOException;
import java.net.URISyntaxException;

public class Exercicio06 {
    private static final Gson gson = new Gson();

    public static void main(String[] args) throws IOException, URISyntaxException {
        try {
            System.out.println("Exercicio 06");

            String[] respostaGet = HTTPClient.get("https://apichallenges.eviltester.com/sim/entities/11");
            System.out.println("Status Code: " + respostaGet[1]);

            if (respostaGet[1].equals("200")) {
                GetRequest request = gson.fromJson(respostaGet[0], GetRequest.class);

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