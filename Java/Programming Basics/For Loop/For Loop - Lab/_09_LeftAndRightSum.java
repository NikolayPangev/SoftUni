import java.util.Scanner;

public class _09_LeftAndRightSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numbers = Integer.parseInt(scanner.nextLine());
        int leftSum = 0;
        int rightSum = 0;

        for (int i = 0; i < 2 * numbers; i++) {
            int currentNum = Integer.parseInt(scanner.nextLine());
            if (i < numbers) {
                leftSum += currentNum;
            } else {
                rightSum += currentNum;
            }
        }

        if (leftSum == rightSum) {
            System.out.printf("Yes, sum = %d", leftSum);
        } else {
            int diff = Math.abs(leftSum - rightSum);
            System.out.printf("No, diff = %d", diff);
        }
    }
}