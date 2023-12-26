import java.util.Scanner;

public class _05_SmallShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String product = scanner.nextLine();
        String town = scanner.nextLine();
        double quantity = Double.parseDouble(scanner.nextLine());

        switch (product) {
            case "coffee":
                switch (town) {
                    case "Sofia":
                        double coffeePriceSofia = 0.50;
                        System.out.println(quantity * coffeePriceSofia);
                        break;
                    case "Plovdiv":
                        double coffeePricePlovdiv = 0.40;
                        System.out.println(quantity * coffeePricePlovdiv);
                        break;
                    case "Varna":
                        double coffeePriceVarna = 0.45;
                        System.out.println(quantity * coffeePriceVarna);
                        break;
                }
                break;
            case "water":
                switch (town) {
                    case "Sofia":
                        double waterPriceSofia = 0.80;
                        System.out.println(quantity * waterPriceSofia);
                        break;
                    case "Plovdiv":
                        double waterPricePlovdiv = 0.70;
                        System.out.println(quantity * waterPricePlovdiv);
                        break;
                    case "Varna":
                        double waterPriceVarna = 0.70;
                        System.out.println(quantity * waterPriceVarna);
                        break;
                }
                break;
            case "beer":
                switch (town) {
                    case "Sofia":
                        double beerPriceSofia = 1.20;
                        System.out.println(quantity * beerPriceSofia);
                        break;
                    case "Plovdiv":
                        double beerPricePlovdiv = 1.15;
                        System.out.println(quantity * beerPricePlovdiv);
                        break;
                    case "Varna":
                        double beerPriceVarna = 1.10;
                        System.out.println(quantity * beerPriceVarna);
                        break;
                }
                break;
            case "sweets":
                switch (town) {
                    case "Sofia":
                        double sweetsPriceSofia = 1.45;
                        System.out.println(quantity * sweetsPriceSofia);
                        break;
                    case "Plovdiv":
                        double sweetsPricePlovdiv = 1.30;
                        System.out.println(quantity * sweetsPricePlovdiv);
                        break;
                    case "Varna":
                        double sweetsPriceVarna = 1.35;
                        System.out.println(quantity * sweetsPriceVarna);
                        break;
                }
                break;
            case "peanuts":
                switch (town) {
                    case "Sofia":
                        double peanutsPriceSofia = 1.60;
                        System.out.println(quantity * peanutsPriceSofia);
                        break;
                    case "Plovdiv":
                        double peanutsPricePlovdiv = 1.50;
                        System.out.println(quantity * peanutsPricePlovdiv);
                        break;
                    case "Varna":
                        double peanutsPriceVarna = 1.55;
                        System.out.println(quantity * peanutsPriceVarna);
                        break;
                }
                break;
        }
    }
}