import java.util.Scanner;

public class Main {
    /**
     * Action by user is required
     */
    public static void init() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please take an action(\"Sign up\" or \"Quit\")");
        String action = scanner.nextLine();
        while (!action.equals("Sign up") && !action.equals("Quit")) {
            System.out.println("Please enter the correct command");
            action = scanner.nextLine();
        }
        if (action.equals("Quit")) {
            System.exit(0);
        }
    }
}
