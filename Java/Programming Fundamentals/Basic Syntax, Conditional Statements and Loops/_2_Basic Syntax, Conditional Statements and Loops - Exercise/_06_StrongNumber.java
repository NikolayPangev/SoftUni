import java.util.Scanner;

public class _06_StrongNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputNumber = scanner.nextLine();

        if (isStrongNumber(inputNumber)) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
    }

    private static boolean isStrongNumber(String number) {
        int totalProduct = 0;

        for (int i = 0; i < number.length(); i++) {
            int digit = Character.getNumericValue(number.charAt(i));
            totalProduct += factorial(digit);
        }

        return totalProduct == Integer.parseInt(number);
    }

    private static int factorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }
}