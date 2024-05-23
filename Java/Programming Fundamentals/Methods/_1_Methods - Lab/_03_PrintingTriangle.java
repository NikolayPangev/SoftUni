import java.util.Scanner;

public class _03_PrintingTriangle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();

        for (int i = 1; i < number; i++) {
            printNumbers(i);
        }

        for (int i = number; i > 0; i--) {
            printNumbers(i);
        }
    }

    private static void printNumbers(int max) {
        for (int i = 1; i <= max; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
