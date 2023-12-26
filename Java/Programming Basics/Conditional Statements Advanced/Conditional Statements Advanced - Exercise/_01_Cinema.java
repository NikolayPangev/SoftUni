import java.util.Scanner;

public class _01_Cinema {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String projection = scanner.nextLine();
        int rows = Integer.parseInt(scanner.nextLine());
        int cols = Integer.parseInt(scanner.nextLine());

        double income = 0.0;

        if ("Premiere".equals(projection)) {
            income = rows * cols * 12.00;
        } else if ("Normal".equals(projection)) {
            income = rows * cols * 7.50;
        } else if ("Discount".equals(projection)) {
            income = rows * cols * 5.00;
        }

        System.out.printf("%.2f leva", income);
    }
}