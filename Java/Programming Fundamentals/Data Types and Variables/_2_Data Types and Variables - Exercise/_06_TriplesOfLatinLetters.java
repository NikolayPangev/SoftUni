import java.util.Scanner;

public class _06_TriplesOfLatinLetters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < number; i++) {
            for (int j = 0; j < number; j++) {
                for (int k = 0; k < number; k++) {
                    char firstChar = (char) ('a' + i);
                    char secondChar = (char) ('a' + j);
                    char thirdChar = (char) ('a' + k);

                    System.out.printf("%c%c%c%n", firstChar, secondChar, thirdChar);
                }
            }
        }
    }
} 