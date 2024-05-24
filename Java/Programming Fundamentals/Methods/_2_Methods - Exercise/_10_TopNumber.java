import java.util.Scanner;

public class _10_TopNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int number = sc.nextInt();

        for (int i = 1; i <= number; i++) {
            if (isTopNumber(i)) {
                System.out.println(i);
            }
        }
    }

    public static boolean isTopNumber(int num) {
        return isSumOfDigitsDivisibleBy8(num) && hasAtLeastOneOddDigit(num);
    }

    public static boolean isSumOfDigitsDivisibleBy8(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum % 8 == 0;
    }

    public static boolean hasAtLeastOneOddDigit(int num) {
        while (num > 0) {
            if ((num % 10) % 2 != 0) {
                return true;
            }
            num /= 10;
        }
        return false;
    }
}
