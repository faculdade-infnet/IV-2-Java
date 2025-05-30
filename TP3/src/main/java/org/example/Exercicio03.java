package org.example;

import com.google.gson.Gson;
import org.example.client.HTTPClient;
import org.example.get.GetRequest;
import java.io.IOException;
import java.net.URISyntaxException;

public class Exercicio03 {
    private static final Gson gson = new Gson();

    public static void main(String[] args) throws IOException, URISyntaxException {
        try {
            System.out.println("Exercicio 03");

            String[] respostaGet = HTTPClient.get("https://apichallenges.eviltester.com/sim/entities/13");
            if (!respostaGet[1].equals("404")) {
                GetRequest request = gson.fromJson(respostaGet[1], GetRequest.class);
            }

            System.out.println("Status Code: " + respostaGet[1] + " " + respostaGet[2]);
        } catch (Exception e) {
            //System.out.println("Status Code: " + respostaGet[0]);
            throw new RuntimeException((e));
        }
    }
}