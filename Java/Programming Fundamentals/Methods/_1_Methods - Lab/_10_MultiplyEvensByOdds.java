import java.util.Scanner;

public class _10_MultiplyEvensByOdds {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String number = sc.nextLine();

        int sumEven = 0;
        int sumOdd = 0;

        for (int i = 0; i < number.length(); i++) {
            char character = number.charAt(i);

            if (!Character.isDigit(character)) {
                continue;
            }

            int digit = Character.getNumericValue(character);

            if (digit % 2 == 0) {
                sumEven += digit;
            } else {
                sumOdd += digit;
            }
        }

        int result = sumEven * sumOdd;
        System.out.println(result);
    }
}
