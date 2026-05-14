package util;

import com.google.gson.JsonObject;

public class EventFormatter {

    public String formatEvent (JsonObject event) {

        String type = event.get("type").getAsString();

        String repositoryName = event.getAsJsonObject("repo").get("name").getAsString();

        return switch (type) {

            case "PushEvent" -> "- Pushed commits to " + repositoryName;

            case "CreateEvent" -> "- Created something in " + repositoryName;

            case "WatchEvent" -> "- Starred " + repositoryName;

            case "IssuesEvent" -> "- Opened an issue in " + repositoryName;

            case "ForkEvent" -> "- Forked " + repositoryName;

            default -> "- Performed " + type + " in " + repositoryName;

        };

    }

}
