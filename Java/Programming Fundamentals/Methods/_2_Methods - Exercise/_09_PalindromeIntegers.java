import java.util.Scanner;

public class _09_PalindromeIntegers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String number = sc.nextLine();
        StringBuilder reverseNumber = new StringBuilder();

        isPalindrome(number, sc);
    }

    private static void isPalindrome(String number, Scanner sc) {
        StringBuilder reverseNumber;
        while (!number.equals("END")) {
            reverseNumber = new StringBuilder();
            for (int i = number.length() - 1; i >= 0; i--) {
                reverseNumber.append(number.charAt(i));
            }

            System.out.println(number.contentEquals(reverseNumber));

            number = sc.nextLine();
        }
    }
}
