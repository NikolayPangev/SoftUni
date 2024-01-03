import java.util.Scanner;

public class _04_FishingBoat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int budget = Integer.parseInt(scanner.nextLine());
        String season = scanner.nextLine();
        int numFisherman = Integer.parseInt(scanner.nextLine());

        double shipPrice = 0.00;
        switch (season) {
            case "Spring":
                shipPrice = 3000.00;
                break;
            case "Summer":
            case "Autumn":
                shipPrice = 4200.00;
                break;
            case "Winter":
                shipPrice = 2600.00;
                break;
        }

        if (numFisherman <= 6) {
            shipPrice = shipPrice - (shipPrice * 0.10);
        } else if (numFisherman <= 11) {
            shipPrice = shipPrice - (shipPrice * 0.15);
        } else {
            shipPrice = shipPrice - (shipPrice * 0.25);
        }

        if (numFisherman % 2 == 0 && !season.equals("Autumn")) {
            shipPrice = shipPrice - (shipPrice * 0.05);
        }

        if (budget >= shipPrice) {
            System.out.printf("Yes! You have %.2f leva left.", budget - shipPrice);
        } else {
            System.out.printf("Not enough money! You need %.2f leva.", shipPrice - budget);
        }
    }
}
