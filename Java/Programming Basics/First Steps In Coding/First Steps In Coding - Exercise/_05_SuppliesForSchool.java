import java.util.Scanner;

public class _05_SuppliesForSchool {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int pens = Integer.parseInt(scanner.nextLine());
        int markers = Integer.parseInt(scanner.nextLine());
        int liters = Integer.parseInt(scanner.nextLine());
        int discount = Integer.parseInt(scanner.nextLine());

        double pensTotal = pens * 5.80;
        double markersTotal = markers * 7.20;
        double litersTotal = liters * 1.20;

        double total = pensTotal + markersTotal + litersTotal;

        double discountPrice = total * discount / 100;

        double result = total - discountPrice;

        System.out.println(result);
    }
}