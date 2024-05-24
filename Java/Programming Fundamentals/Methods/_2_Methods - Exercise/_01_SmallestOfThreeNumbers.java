import java.util.Scanner;

public class _01_SmallestOfThreeNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num1 = sc.nextInt();
        int num2 = sc.nextInt();
        int num3 = sc.nextInt();

        smallestOfThreeNumbers(num1, num2, num3);
    }

    private static void smallestOfThreeNumbers(int num1, int num2, int num3) {
        int smallest = num1;

        if (num2 < smallest) {
            smallest = num2;
        }
        if (num3 < smallest) {
            smallest = num3;
        }

        System.out.println(smallest);
    }
}
