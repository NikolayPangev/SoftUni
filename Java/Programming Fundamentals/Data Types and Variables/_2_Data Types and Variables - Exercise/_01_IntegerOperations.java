import java.util.Scanner;

public class _01_IntegerOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num1 = Integer.parseInt(scanner.nextLine());
        int num2 = Integer.parseInt(scanner.nextLine());
        int num3 = Integer.parseInt(scanner.nextLine());
        int num4 = Integer.parseInt(scanner.nextLine());

        int sum = num1 + num2;
        int division = sum / num3;
        int product = division * num4;

        System.out.println(product);
    }
} 