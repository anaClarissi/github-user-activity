package service;

import com.google.gson.*;
import model.GitHubEvent;
import util.EventFormatter;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class GitHubService {

    public void fetchUserActivity (String username) {

        try {

            String url = String.format("https://api.github.com/users/%s/events", username);

            HttpClient client = HttpClient.newHttpClient();

            HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).GET().build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 404) {

                System.out.println("User not found.");

                return;

            }

            if (response.statusCode() == 403) {

                System.out.println("API rate limit exceeded.");

                return;

            }

            JsonArray jsonArray = JsonParser.parseString(response.body()).getAsJsonArray();

            EventFormatter formatter = new EventFormatter();

            for (JsonElement element : jsonArray) {

                JsonObject eventJson = element.getAsJsonObject();

                String type = eventJson.get("type").getAsString();

                String repositoryName = eventJson.getAsJsonObject("repo").get("name").getAsString();

                GitHubEvent event = new GitHubEvent(type, repositoryName);

                String formatedMessage = formatter.formatEvent(event);

                System.out.println(formatedMessage);

            }


        } catch (IOException e) {

            throw new RuntimeException(e);

        } catch (InterruptedException e) {

            throw new RuntimeException("Error: ", e);

        }
    }

}
