import java.util.Scanner;

public class _02_FromLeftToTheRight {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfLines = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numberOfLines; i++) {
            String[] numbers = scanner.nextLine().split(" ");
            long leftNumber = Long.parseLong(numbers[0]);
            long rightNumber = Long.parseLong(numbers[1]);

            int sumOfDigits;
            if (leftNumber >= rightNumber) {
                leftNumber = Math.abs(leftNumber);
                sumOfDigits = getSumOfDigits(leftNumber);
            } else {
                rightNumber = Math.abs(rightNumber);
                sumOfDigits = getSumOfDigits(rightNumber);
            }

            System.out.println(sumOfDigits);
        }
    }

    private static int getSumOfDigits(long number) {
        int sum = 0;
        while (number != 0) {
            sum += (int) (number % 10);
            number /= 10;
        }
        return sum;
    }
}