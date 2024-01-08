import java.util.Scanner;

public class _05_Login {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String username = scanner.nextLine();
        String inputPassword = scanner.nextLine();
        String password = "";
        int countWrongLogins = 0;

        for (int position = username.length() - 1; position >= 0; position--) {
            char currentSymbol = username.charAt(position);
            password += currentSymbol;
        }

        while (!inputPassword.equals(password)) {
            if (countWrongLogins == 3) {
                System.out.printf("User %s blocked!", username);
                break;
            }
            System.out.println("Incorrect password. Try again.");
            countWrongLogins++;
            inputPassword = scanner.nextLine();
        }
        if (inputPassword.equals(password)) {
            System.out.printf("User %s logged in.", username);
        }
    }
}