import java.util.Scanner;

public class _05_GodzillavsKong {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double budget = Double.parseDouble(scanner.nextLine());
        int numStatist = Integer.parseInt(scanner.nextLine());
        double priceStatist = Double.parseDouble(scanner.nextLine());

        double sumDecor = budget * 0.1;
        double sumStatists = numStatist * priceStatist;

        if(numStatist > 150){
            sumStatists *= 0.9;
        }

        double sumMovie = sumStatists + sumDecor;

        if (sumMovie > budget) {
            System.out.println("Not enough money!");
            System.out.printf("Wingard needs %.2f leva more.", (sumMovie - budget));
        } else {
            System.out.println("Action!");
            System.out.printf("Wingard starts filming with %.2f leva left.", (budget - sumMovie));
        }
    }
}