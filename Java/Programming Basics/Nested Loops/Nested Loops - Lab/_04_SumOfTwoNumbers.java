import java.util.Scanner;

public class _04_SumOfTwoNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int beginning = Integer.parseInt(scanner.nextLine());
        int end = Integer.parseInt(scanner.nextLine());
        int magicNumber = Integer.parseInt(scanner.nextLine());
        int count = 0;
        boolean isFound = false;

        for (int x1 = beginning; x1 <= end; x1++) {
            for (int x2 = beginning; x2 <= end; x2++) {
                count++;
                if (x1 + x2 == magicNumber) {
                    isFound = true;
                    System.out.printf("Combination N:%d (%d + %d = %d)", count, x1, x2, magicNumber);
                    return;
                }
            }
        }
        System.out.printf("%d combinations - neither equals %d", count, magicNumber);
    }
}