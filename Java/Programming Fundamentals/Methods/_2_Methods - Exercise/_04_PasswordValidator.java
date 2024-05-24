import java.util.Scanner;

public class _04_PasswordValidator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String password = sc.nextLine();
        validatePassword(password);
    }

    public static void validatePassword(String password) {
        boolean isValid = true;

        if (password.length() < 6 || password.length() > 10) {
            System.out.println("Password must be between 6 and 10 characters");
            isValid = false;
        }

        int countDigits = 0;
        for (int i = 0; i < password.length(); i++) {
            char ch = password.charAt(i);
            if (!Character.isLetterOrDigit(ch)) {
                System.out.println("Password must consist only of letters and digits");
                isValid = false;
                break;
            }
            if (Character.isDigit(ch)) {
                countDigits++;
            }
        }

        if (countDigits < 2) {
            System.out.println("Password must have at least 2 digits");
            isValid = false;
        }

        if (isValid) {
            System.out.println("Password is valid");
        }
    }
}
