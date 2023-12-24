import java.util.Scanner;

public class _07_Shopping {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());
        double numVideoCards = Double.parseDouble(scanner.nextLine());
        double numProcessors = Double.parseDouble(scanner.nextLine());
        double numRam = Double.parseDouble(scanner.nextLine());

        double videoCard = 250;
        double totalVideoCard = numVideoCards * videoCard;

        double processor = totalVideoCard * 0.35;
        double totalProcessors = numProcessors * processor;

        double ram = totalVideoCard * 0.1;
        double totalRam = numRam * ram;

        double total = totalVideoCard + totalProcessors + totalRam;

        if (numVideoCards > numProcessors) {
            total *= 0.85;
        }

        if (budget >= total) {
            System.out.printf("You have %.2f leva left!", (budget - total));
        } else {
            System.out.printf("Not enough money! You need %.2f leva more!", (total - budget));
        }
    }
}