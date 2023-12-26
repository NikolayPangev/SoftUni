import java.util.Scanner;

public class _03_NewHouse {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String typeFlower = scanner.nextLine();
        int numFlowers = Integer.parseInt(scanner.nextLine());
        int budget = Integer.parseInt(scanner.nextLine());
        double flowers = 0.0;

        switch (typeFlower) {
            case "Roses":
                flowers = numFlowers * 5.00;
                if (numFlowers > 80) {
                    flowers *= 0.9;
                }
                break;
            case "Dahlias":
                flowers = numFlowers * 3.80;
                if (numFlowers > 90) {
                    flowers *= 0.85;
                }
                break;
            case "Tulips":
                flowers = numFlowers * 2.80;
                if (numFlowers > 80) {
                    flowers *= 0.85;
                }
                break;
            case "Narcissus":
                flowers = numFlowers * 3.00;
                if (numFlowers < 120) {
                    flowers *= 1.15;
                }
                break;
            case "Gladiolus":
                flowers = numFlowers * 2.50;
                if (numFlowers < 80) {
                    flowers *= 1.20;
                }
                break;
        }

        if (budget >= flowers) {
            System.out.printf("Hey, you have a great garden with %d %s and %.2f leva left.", numFlowers, typeFlower, (budget - flowers));
        } else {
            System.out.printf("Not enough money, you need %.2f leva more.", (flowers - budget));
        }
    }
}