import java.util.Scanner;

public class _07_VendingMachine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();
        double sum = 0.0;

        while (!command.equals("Start")) {
            double number = Double.parseDouble(command);
            if (number == 0.1 || number == 0.2 || number == 0.5 || number == 1 || number == 2) {
                sum += number;
            } else {
                System.out.printf("Cannot accept %.2f\n", number);
            }
            command = scanner.nextLine();
        }

        command = scanner.nextLine();

        while (!command.equals("End")) {
            switch (command) {
                case "Nuts":
                    if (sum >= 2.0) {
                        System.out.printf("Purchased %s\n", command);
                        sum -= 2.0;
                    } else {
                        System.out.println("Sorry, not enough money");
                    }
                    break;
                case "Water":
                    if (sum >= 0.7) {
                        System.out.printf("Purchased %s\n", command);
                        sum -= 0.7;
                    } else {
                        System.out.println("Sorry, not enough money");
                    }
                    break;
                case "Crisps":
                    if (sum >= 1.5) {
                        System.out.printf("Purchased %s\n", command);
                        sum -= 1.5;
                    } else {
                        System.out.println("Sorry, not enough money");
                    }
                    break;
                case "Soda":
                    if (sum >= 0.8) {
                        System.out.printf("Purchased %s\n", command);
                        sum -= 0.8;
                    } else {
                        System.out.println("Sorry, not enough money");
                    }
                    break;
                case "Coke":
                    if (sum >= 1.0) {
                        System.out.printf("Purchased %s\n", command);
                        sum -= 1.0;
                    } else {
                        System.out.println("Sorry, not enough money");
                    }
                    break;
                default:
                    System.out.println("Invalid product");
                    break;
            }
            command = scanner.nextLine();
        }

        System.out.printf("Change: %.2f", sum);
    }
}