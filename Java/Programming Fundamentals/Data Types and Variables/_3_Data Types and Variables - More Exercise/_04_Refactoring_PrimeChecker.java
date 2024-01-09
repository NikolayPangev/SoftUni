import java.util.Scanner;

public class _04_Refactoring_PrimeChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        for (int currentNumber = 2; currentNumber <= n; currentNumber++) {
            boolean isPrime = true;

            for (int divisor = 2; divisor < currentNumber; divisor++) {
                if (currentNumber % divisor == 0) {
                    isPrime = false;
                    break;
                }
            }
            System.out.printf("%d -> %b%n", currentNumber, isPrime);
        }
    }
}