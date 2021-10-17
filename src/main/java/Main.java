import java.util.Scanner;

public class Main {
    /**
     * Action by user is required
     */
    public static void init() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please take an action(\"Register\" or \"Cancel\")");
        String action = scanner.nextLine();
        while (!action.equals("Register") && !action.equals("Cancel")) {
            System.out.println("Please enter the correct command");
            action = scanner.nextLine();
        }
        if (action.equals("Cancel")) {
            System.exit(0);
        }
    }

    public static void main(String[] args){
        init();
        Register new_register = new Register();
        // TODO: add name, email, password, to user
        User new_user = new User();
        new_register.addUser(new_user);

    }
}
