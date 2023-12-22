import java.util.Scanner;

public class _07_FoodDelivery {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int chickenMenu = Integer.parseInt(scanner.nextLine());
        int fishMenu = Integer.parseInt(scanner.nextLine());
        int veganMenu = Integer.parseInt(scanner.nextLine());

        double chickenMenuPrice = chickenMenu * 10.35;
        double fishMenuPrice = fishMenu * 12.40;
        double veganMenuPrice = veganMenu * 8.15;
        double totalMenu = chickenMenuPrice + fishMenuPrice + veganMenuPrice;

        double desert = 0.2 * totalMenu;
        double delivery = 2.50;

        double total = totalMenu + desert + delivery;
        System.out.println(total);

    }
}
