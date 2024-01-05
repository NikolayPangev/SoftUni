import java.util.Scanner;

public class _05_AccountBalance {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();
        double sum = 0;

        while (!command.equals("NoMoreMoney")) {
            double number = Double.parseDouble(command);
            if (number < 0) {
                System.out.println("Invalid operation!");
                break;
            }
            sum += number;
            System.out.printf("Increase: %.2f\n", number);
            command = scanner.nextLine();
        }

        System.out.printf("Total: %.2f", sum);
    }
}