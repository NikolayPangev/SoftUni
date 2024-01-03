import java.util.Scanner;

public class _05_Journey {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double budget = Double.parseDouble(scanner.nextLine());
        String season = scanner.nextLine();
        double price = 0.0;
        String place = "";
        String residence = "";

        switch (season) {
            case "summer":
                residence = "Camp";
                if (budget <= 100) {
                    price = budget * 0.3;
                    place = "Bulgaria";
                } else if (budget <= 1000) {
                    price = budget * 0.4;
                    place = "Balkans";
                } else {
                    price = budget * 0.9;
                    place = "Europe";
                    residence = "Hotel";
                }
                break;
            case "winter":
                residence = "Hotel";
                if (budget <= 100) {
                    price = budget * 0.7;
                    place = "Bulgaria";
                } else if (budget <= 1000) {
                    price = budget * 0.8;
                    place = "Balkans";
                } else {
                    price = budget * 0.9;
                    place = "Europe";
                }
                break;
        }
        System.out.printf("Somewhere in %s\n", place);
        System.out.printf("%s - %.2f", residence, price);
    }
}