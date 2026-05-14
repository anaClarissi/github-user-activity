import exception.ApiException;
import service.GitHubService;

public class Main {

    public static void main(String[] args) {

        if (args.length < 1) {

            System.out.println("Usage: github-activity <username>");

            return;

        }

        System.out.printf("Searching for user activities: %s\n", args[0]);

        String username = args[0];

        GitHubService service = new GitHubService();

        try {

            service.fetchUserActivity(username);

        } catch (ApiException e) {

            System.out.println(e.getMessage());

        }

    }

}
