import java.util.Scanner;

public class _05_Messages {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int cycles = Integer.parseInt(scanner.nextLine());
        StringBuilder output = new StringBuilder();

        for (int i = 0; i < cycles; i++) {
            int number = Integer.parseInt(scanner.nextLine());
            char result = numberToAlphabet(number);
            output.append(result);
        }

        System.out.println(output.toString());
    }

    public static char numberToAlphabet(int number) {
        if (number == 0) {
            return ' ';
        }

        int numDigits = (int) Math.log10(number) + 1;

        int mainDigit = Character.getNumericValue(Integer.toString(number).charAt(0));

        int offset = (mainDigit - 2) * 3;

        if (mainDigit == 8 || mainDigit == 9) {
            offset += 1;
        }

        int letterIndex = offset + numDigits - 1;

        int asciiCode = 'a' + letterIndex;

        return (char) asciiCode;
    }
}
