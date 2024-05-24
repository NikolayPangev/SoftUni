import java.util.Scanner;

public class _05_MultiplicationSign {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num1 = sc.nextInt();
        int num2 = sc.nextInt();
        int num3 = sc.nextInt();

        printSignOfProduct(num1, num2, num3);
    }

    private static void printSignOfProduct(int num1, int num2, int num3) {
        if (num1 == 0 || num2 == 0 || num3 == 0) {
            System.out.println("zero");
            return;
        }

        int negativeCount = 0;

        if (num1 < 0) negativeCount++;
        if (num2 < 0) negativeCount++;
        if (num3 < 0) negativeCount++;

        if (negativeCount % 2 == 0) {
            System.out.println("positive");
        } else {
            System.out.println("negative");
        }
    }
}
