import java.util.Scanner;

public class _03_GamingStore {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double currentBalance = Double.parseDouble(scanner.nextLine());
        double beginningBalance = currentBalance;
        String command = scanner.nextLine();
        double price;

        while (!command.equals("Game Time")) {
            if (currentBalance <= 0) {
                System.out.println("Out of money!");
                return;
            }
            switch (command) {
                case "OutFall 4":
                    price = 39.99;
                    if (isItExpensive(currentBalance, price)) {
                        break;
                    }
                    System.out.println("Bought OutFall 4");
                    currentBalance -= price;
                    break;
                case "CS: OG":
                    price = 15.99;
                    if (isItExpensive(currentBalance, price)) {
                        break;
                    }
                    System.out.println("Bought CS: OG");
                    currentBalance -= price;
                    break;
                case "Zplinter Zell":
                    price = 19.99;
                    if (isItExpensive(currentBalance, price)) {
                        break;
                    }
                    System.out.println("Bought Zplinter Zell");
                    currentBalance -= price;
                    break;
                case "Honored 2":
                    price = 59.99;
                    if (isItExpensive(currentBalance, price)) {
                        break;
                    }
                    System.out.println("Bought Honored 2");
                    currentBalance -= price;
                    break;
                case "RoverWatch":
                    price = 29.99;
                    if (isItExpensive(currentBalance, price)) {
                        break;
                    }
                    System.out.println("Bought RoverWatch");
                    currentBalance -= price;
                    break;
                case "RoverWatch Origins Edition":
                    price = 39.99;
                    if (isItExpensive(currentBalance, price)) {
                        break;
                    }
                    System.out.println("Bought RoverWatch Origins Edition");
                    currentBalance -= price;
                    break;
                default:
                    System.out.println("Not Found");
                    break;
            }

            command = scanner.nextLine();
        }
        if (currentBalance > 0) {
            System.out.printf("Total spent: $%.2f. Remaining: $%.2f", beginningBalance - currentBalance, currentBalance);
        } else {
            System.out.println("Out of money!");
        }
    }
    private static boolean isItExpensive(double balance, double price) {
        if (price > balance) {
            System.out.println("Too Expensive");
            return true;
        }
        return false;
    }
}