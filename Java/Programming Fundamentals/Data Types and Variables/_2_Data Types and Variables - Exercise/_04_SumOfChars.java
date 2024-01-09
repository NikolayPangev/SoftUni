import java.util.Scanner;

public class _04_SumOfChars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = Integer.parseInt(scanner.nextLine());
        int sum = 0;

        for (int i = 0; i < number; i++) {
            char character = scanner.nextLine().charAt(0);
            sum += character;
        }
        System.out.printf("The sum equals: %d", sum);
    }
} 