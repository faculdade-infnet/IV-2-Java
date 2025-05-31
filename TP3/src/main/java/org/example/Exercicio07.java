package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import org.example.client.HTTPClient;
import org.example.get.GetRequest;
import org.example.post.PostRequest;

import java.io.IOException;
import java.net.URISyntaxException;

public class Exercicio07 {
    private static final Gson gson = new Gson();
    private static final Gson gson1 = new GsonBuilder().setPrettyPrinting().create();
    public static void main(String[] args) throws IOException, URISyntaxException {
        try {
            System.out.println("Exercicio 07");

            PostRequest postRequest = new PostRequest(
                    "atualizado"
            );

            String[] respostaPost = HTTPClient.post("https://apichallenges.eviltester.com/sim/entities/10", postRequest);

            String[] respostaGet = HTTPClient.get("https://apichallenges.eviltester.com/sim/entities/10");
            GetRequest request = gson.fromJson(respostaGet[0], GetRequest.class);

            System.out.println("Status Code: " + respostaGet[1]);
            System.out.println(request);

        } catch (Exception e) {
            throw new RuntimeException((e));
        }
    }
}
