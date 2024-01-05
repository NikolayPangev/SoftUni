import java.util.Scanner;

public class _04_CleverLily {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int age = Integer.parseInt(scanner.nextLine());
        double priceForWashingMachine = Double.parseDouble(scanner.nextLine());
        int priceForToy = Integer.parseInt(scanner.nextLine());
        double sum = 0;
        int count = 0;
        int toys = 0;
        double finalSum = 0;

        for (int currentAge = 1; currentAge <= age; currentAge++) {
            if (currentAge % 2 == 0) {
                sum += (double) (10 * currentAge) / 2;
                count++;
            } else {
                toys++;
            }
        }

        finalSum = (sum - count) + toys * priceForToy;

        if (finalSum >= priceForWashingMachine) {
            System.out.printf("Yes! %.2f", finalSum - priceForWashingMachine);
        } else {
            System.out.printf("No! %.2f", priceForWashingMachine - finalSum);
        }
    }
}
