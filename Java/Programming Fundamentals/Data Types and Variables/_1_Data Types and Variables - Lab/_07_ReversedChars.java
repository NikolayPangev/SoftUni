import java.util.Scanner;

public class _07_ReversedChars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder word = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            char letter = scanner.nextLine().charAt(0);
            word.append(letter);
        }

        for (int i = word.length() - 1; i >= 0; i--) {
            System.out.print(word.charAt(i) + " ");
        }
    }
}