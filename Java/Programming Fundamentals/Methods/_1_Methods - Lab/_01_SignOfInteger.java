import java.util.Scanner;

public class _01_SignOfInteger {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();

        if (number < 0) {
            System.out.printf("The number %d is negative.", number);
        } else if (number == 0) {
            System.out.printf("The number %d is zero.", number);
        } else {
            System.out.printf("The number %d is positive.", number);
        }
    }
}
