import java.util.Scanner;

public class _03_DepositCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double deposit = Double.parseDouble(scanner.nextLine());
        int term = Integer.parseInt(scanner.nextLine());
        double percent = Double.parseDouble(scanner.nextLine());

        double accruedInterest = deposit * percent / 100;
        double interestForAMonth = accruedInterest / 12;
        double totalSum = deposit + term * interestForAMonth;
        System.out.println(totalSum);
    }
}