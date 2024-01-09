import java.util.Scanner;

public class _08_BeerKegs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = Integer.parseInt(scanner.nextLine());
        double max = 0;
        String winner = null;

        for (int i = 0; i < number; i++) {
            String model = scanner.nextLine();
            double radius = Double.parseDouble(scanner.nextLine());
            int height = Integer.parseInt(scanner.nextLine());

            double volume = Math.PI * Math.pow(radius, 2) * height;

            if (volume > max) {
                max = volume;
                winner = model;
            }
        }
        System.out.println(winner);
    }
}