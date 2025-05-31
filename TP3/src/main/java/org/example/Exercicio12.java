package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import org.example.client.HTTPClient;
import org.example.get.GetRequest;
import org.example.post.RequestExercicio12;

import java.io.IOException;
import java.net.URISyntaxException;

public class Exercicio12 {
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public static void main(String[] args) throws IOException, URISyntaxException {
        try {
            System.out.println("Exercicio 12");

            // a. GET todos itens
            String[] respostaGet = HTTPClient.get("https://apichallenges.eviltester.com/simpleapi/items");

            System.out.println("Status Code: " + respostaGet[1]);
            System.out.println("Corpo da Resposta:" + respostaGet[0]);

            // b. GET ISBN aletótio
            String[] respostaGet1 = HTTPClient.get("https://apichallenges.eviltester.com/simpleapi/randomisbn");

            System.out.println("Status Code: " + respostaGet1[1]);
            System.out.println("Corpo da Resposta:" + respostaGet1[0]);
            String isbn = gson.fromJson(respostaGet1[0], String.class);

            // c. Criar item com POST
            RequestExercicio12 postRequest = new RequestExercicio12(
                    isbn,
                    "book",
                    45.92,
                    1
            );

            String[] respostaPost = HTTPClient.post("https://apichallenges.eviltester.com/simpleapi/items", postRequest);
            System.out.println("Status Code: " + respostaPost[1]);
            System.out.println("Corpo da Resposta:" + respostaPost[0]);

            // d. Atualizar item com PUT
            // Extrair o ID do item criado
            String itemId = null;
            if (respostaPost[0] != null && !respostaPost[0].isEmpty()) {
                JsonObject itemCriado = gson.fromJson(respostaPost[0], JsonObject.class);

                // Verifica se o item criado tem um id
                if (itemCriado.has("id")) {
                    itemId = itemCriado.get("id").getAsString();
                }
            }

            RequestExercicio12 putRequest = new RequestExercicio12(
                    isbn,
                    "book",
                    100,
                    1
            );

            String[] respostaPut = HTTPClient.put("https://apichallenges.eviltester.com/simpleapi/items/" + itemId, putRequest);
            System.out.println("Status Code: " + respostaPut[1]);
            System.out.println("Corpo da Resposta:" + respostaPut[0]);

            // e. Remover item com DELETE
            String[] respostaDelete = HTTPClient.delete("https://apichallenges.eviltester.com/simpleapi/items/" + itemId);
            System.out.println("Status Code: " + respostaDelete[1] + " " + respostaDelete[2]);
            System.out.println("Corpo da Resposta:" + respostaDelete[0]);

        } catch (Exception e) {
            throw new RuntimeException((e));
        }
    }
}