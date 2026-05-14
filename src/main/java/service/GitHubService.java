package service;

import com.google.gson.*;

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

            JsonArray jsonArray = JsonParser.parseString(response.body()).getAsJsonArray();

            for (JsonElement element : jsonArray) {

                JsonObject event = element.getAsJsonObject();

                String type = event.get("type").getAsString();

                String repositoryName = event.getAsJsonObject("repo").get("name").getAsString();

                switch (type) {

                    case "PushEvent" -> System.out.println("- Pushed commits to " + repositoryName);

                    case "CreateEvent" -> System.out.println("- Created something in " + repositoryName);

                    case "WatchEvent" -> System.out.println("- Starred " + repositoryName);

                    case "IssuesEvent" -> System.out.println("- Opened an issue in " + repositoryName);

                    case "ForkEvent" -> System.out.println("- Forked " + repositoryName);

                }

            }


        } catch (IOException e) {

            throw new RuntimeException(e);

        } catch (InterruptedException e) {

            throw new RuntimeException("Error: ", e);

        }
    }

}
