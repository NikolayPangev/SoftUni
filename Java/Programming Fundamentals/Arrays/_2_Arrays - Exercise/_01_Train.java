import java.util.Scanner;

public class _01_Train {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int wagonsNum = Integer.parseInt(scanner.nextLine());
        int sum = 0;
        int[] wagons = new int[wagonsNum];

        for (int wagon = 0; wagon < wagonsNum; wagon++) {
            int num = Integer.parseInt(scanner.nextLine());
            wagons[wagon] = num;
            sum += num;
        }

        for (int wagon : wagons) {
            System.out.print(wagon + " ");
        }
        System.out.printf("\n%d", sum);
    }
}