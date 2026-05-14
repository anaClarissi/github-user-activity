package service;

import com.google.gson.*;
import exception.ApiException;
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

            validateResponse(response);

            JsonArray jsonArray = JsonParser.parseString(response.body()).getAsJsonArray();

            EventFormatter formatter = new EventFormatter();

            for (JsonElement element : jsonArray) {

                JsonObject eventJson = element.getAsJsonObject();

                GitHubEvent event = createEvent(eventJson);

                String formattedMessage = formatter.formatEvent(event);

                System.out.println(formattedMessage);

            }


        } catch (IOException e) {

            throw new ApiException("Error communicating with GitHub API.");

        } catch (InterruptedException e) {

            throw new ApiException("Request interrupted.");

        }
    }

    private GitHubEvent createEvent (JsonObject eventJson) {

        String type = eventJson.get("type").getAsString();

        String repositoryName = eventJson.getAsJsonObject("repo").get("name").getAsString();

        return new GitHubEvent(type, repositoryName);

    }

    private void validateResponse (HttpResponse<String> response) {

        if (response.statusCode() == 404) {

            throw new ApiException("User not found.");

        }

        if (response.statusCode() == 403) {

            throw new ApiException("API rate limit exceeded.");

        }

        if (response.statusCode() >= 500) {

            throw new ApiException("GitHub API is unavailable.");

        }

    }

}
