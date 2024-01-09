import java.util.Scanner;

public class _05_DecryptingMessage {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int key = Integer.parseInt(scanner.nextLine());
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= n; i++) {
            char line = scanner.nextLine().charAt(0);

            char newChar = (char) ((int) line + key);
            System.out.print(newChar + "");
        }
    }
}