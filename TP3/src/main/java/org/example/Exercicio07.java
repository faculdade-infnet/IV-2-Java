package org.example;

import com.google.gson.Gson;
import org.example.client.HTTPClient;
import org.example.get.GetRequest;
import org.example.post.PostRequest;

import java.io.IOException;
import java.net.URISyntaxException;

// A API não permite alterar os valores via POST
public class Exercicio07 {
    private static final Gson gson = new Gson();

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
            System.out.println("{\n" +
                    "  id: " + request.id() + ",\n" +
                    "  name: \"" + request.name() + "\",\n" +
                    "  description: \"" + request.description() + "\"\n" +
                    "}");

        } catch (Exception e) {
            throw new RuntimeException((e));
        }
    }
}
