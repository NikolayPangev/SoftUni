import java.util.Scanner;

public class _05_SpecialNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int myNumber = Integer.parseInt(scanner.nextLine());

        for (int currentNumber = 1111; currentNumber <= 9999; currentNumber++) {

            String textNumber = String.valueOf(currentNumber);
            boolean isSpecial = true;

            for (int position = 0; position < textNumber.length(); position++) {
                int currentDigit = Integer.parseInt(textNumber.charAt(position) + "");
                if (currentDigit == 0){
                    isSpecial = false;
                    break;
                }
                if (myNumber % currentDigit != 0) {
                    isSpecial = false;
                    break;
                }
            }
            if (isSpecial) {
                System.out.print(currentNumber + " ");
            }
        }
    }
}