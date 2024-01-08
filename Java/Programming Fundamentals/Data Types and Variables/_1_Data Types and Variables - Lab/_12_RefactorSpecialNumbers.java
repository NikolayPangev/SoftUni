import java.util.Scanner;

public class _12_RefactorSpecialNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = Integer.parseInt(scanner.nextLine());

        for (int currentNumber = 1; currentNumber <= count; currentNumber++) {
            int sumOfDigits = 0;
            int originalNumber = currentNumber;

            while (currentNumber > 0) {
                sumOfDigits += currentNumber % 10;
                currentNumber = currentNumber / 10;
            }

            boolean isSpecialNumber = (sumOfDigits == 5) || (sumOfDigits == 7) || (sumOfDigits == 11);

            System.out.printf("%d -> %s%n", originalNumber, capitalizeFirstLetter(Boolean.toString(isSpecialNumber)));

            currentNumber = originalNumber;
        }
    }
    private static String capitalizeFirstLetter(String str) {
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }
}