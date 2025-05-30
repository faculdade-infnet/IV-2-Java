package org.example;

import com.google.gson.Gson;
import org.example.client.HTTPClient;
import org.example.get.GetRequest;
import org.example.post.PostRequest;

import java.io.IOException;
import java.net.URISyntaxException;

public class Exercicio05 {
    private static final Gson gson = new Gson();

    public static void main(String[] args) throws IOException, URISyntaxException {
        try {
            System.out.println("Exercicio 05");

            PostRequest postRequest = new PostRequest(
                    "Aluno"
            );

            String[] respostaPost = HTTPClient.post("https://apichallenges.eviltester.com/sim/entities", postRequest);
            System.out.println("Status Code: " + respostaPost[1]);
            System.out.println("Corpo: " + respostaPost[0]);

            // Pega o ID criado parseando a resposta com a classe com as mesmas proprieades do objeto da API
            GetRequest response = gson.fromJson(respostaPost[0], GetRequest.class);
            System.out.println("ID criado: " + response.id());

        } catch (Exception e) {
            throw new RuntimeException((e));
        }
    }
}
