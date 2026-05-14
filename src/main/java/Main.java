public class Main {

    public static void main(String[] args) {

        if (args.length < 1) {

            System.out.println("Usage: github-activity <username>");

            return;

        }

        System.out.printf("Searching for user activities: %s", args[0]);

    }

}
