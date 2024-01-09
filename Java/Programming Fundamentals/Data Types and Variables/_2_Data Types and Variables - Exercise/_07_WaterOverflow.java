import java.util.Scanner;

public class _07_WaterOverflow {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = Integer.parseInt(scanner.nextLine());
        int waterTank = 0;

        for (int i = 0; i < number; i++) {
            int quantities = Integer.parseInt(scanner.nextLine());

            if (waterTank + quantities <= 255) {
                waterTank += quantities;
            } else {
                System.out.println("Insufficient capacity!");
            }
        }
        System.out.println(waterTank);
    }
} 