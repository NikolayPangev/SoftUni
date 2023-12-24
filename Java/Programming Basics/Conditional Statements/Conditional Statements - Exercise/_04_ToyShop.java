import java.util.Scanner;

public class _04_ToyShop {
    public static void main(String[] args) {
        double puzzle = 2.60;
        double speakingDoll = 3;
        double bear = 4.10;
        double minion = 8.20;
        double truck = 2;

        Scanner scanner = new Scanner(System.in);
        double excursion = Double.parseDouble(scanner.nextLine());
        int numPuzzles = Integer.parseInt(scanner.nextLine());
        int numDolls = Integer.parseInt(scanner.nextLine());
        int numBears = Integer.parseInt(scanner.nextLine());
        int numMinions = Integer.parseInt(scanner.nextLine());
        int numTrucks = Integer.parseInt(scanner.nextLine());

        int totalNumber = numPuzzles + numDolls + numBears + numMinions + numTrucks;

        double pricePuzzle = numPuzzles * puzzle;
        double priceDoll = numDolls * speakingDoll;
        double priceBear = numBears * bear;
        double priceMinion = numMinions * minion;
        double priceTruck = numTrucks * truck;

        double totalPrice = pricePuzzle + priceDoll + priceBear + priceMinion + priceTruck;

        if (totalNumber >= 50) {
            totalPrice = totalPrice * 0.75;
        }

        totalPrice *= 0.9;

        if (totalPrice >= excursion) {
            System.out.printf("Yes! %.2f lv left.", (totalPrice - excursion));
        } else {
            System.out.printf("Not enough money! %.2f lv needed.", (excursion - totalPrice));
        }
    }
}
