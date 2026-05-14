package util;

import model.GitHubEvent;

public class EventFormatter {

    public String formatEvent (GitHubEvent event) {

        return switch (event.type()) {

            case "PushEvent" -> "- Pushed commits to " + event.repositoryName();

            case "CreateEvent" -> "- Created something in " + event.repositoryName();

            case "WatchEvent" -> "- Starred " + event.repositoryName();

            case "IssuesEvent" -> "- Opened an issue in " + event.repositoryName();

            case "ForkEvent" -> "- Forked " + event.repositoryName();

            default -> "- Performed " + event.type() + " in " + event.repositoryName();

        };

    }

}
