import java.util.Scanner;

public class _03_Vacation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double neededMoney = Double.parseDouble(scanner.nextLine());
        double availableMoney = Double.parseDouble(scanner.nextLine());
        int spendCount = 0;
        int daysCount = 0;

        while (availableMoney < neededMoney) {
            String command = scanner.nextLine();
            double money = Double.parseDouble(scanner.nextLine());
            daysCount++;

            if (command.equals("spend")) {
                availableMoney -= money;
                spendCount++;
                if (availableMoney < 0) {
                    availableMoney = 0;
                }
                if (spendCount == 5) {
                    System.out.println("You can't save the money.");
                    System.out.println(daysCount);
                    return;
                }
            } else if (command.equals("save")) {
                spendCount = 0;
                availableMoney += money;
            }
        }

        System.out.printf("You saved the money for %d days.", daysCount);
    }
}
