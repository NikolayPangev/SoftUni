import java.util.Scanner;

public class _02_EnglishNameOfTheLastDigit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = Integer.parseInt(scanner.nextLine());

        String lastDigit = getLastDigitName(number);
        System.out.println(lastDigit);
    }

    private static String getLastDigitName(int number) {
        number = Math.abs(number);
        int lastDigit = number % 10;

        switch (lastDigit) {
            case 0:
                return "zero";
            case 1:
                return "one";
            case 2:
                return "two";
            case 3:
                return "three";
            case 4:
                return "four";
            case 5:
                return "five";
            case 6:
                return "six";
            case 7:
                return "seven";
            case 8:
                return "eight";
            case 9:
                return "nine";
            default:
                return "";
        }
    }
}