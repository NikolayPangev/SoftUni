import java.util.Scanner;

public class _10_OddEvenSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int evenSum = 0;
        int oddSum = 0;

        for (int i = 0; i < n; i++) {
            int number = scanner.nextInt();

            if (i % 2 == 0) {
                evenSum += number;
            } else {
                oddSum += number;
            }
        }

        int diff = Math.abs(evenSum - oddSum);

        if (evenSum == oddSum) {
            System.out.println("Yes");
            System.out.println("Sum = " + evenSum);
        } else {
            System.out.println("No");
            System.out.println("Diff = " + diff);
        }
    }
}