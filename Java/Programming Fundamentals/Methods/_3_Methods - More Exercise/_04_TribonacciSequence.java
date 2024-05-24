import java.util.Scanner;

public class _04_TribonacciSequence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();

        printTribonacciSequence(num);
    }

    public static void printTribonacciSequence(int num) {
        int[] tribonacci = new int[Math.max(1, num)];
        tribonacci[0] = 1;
        tribonacci[1] = 1;
        tribonacci[2] = 2;

        for (int i = 0; i < num && i < 3; i++) {
            System.out.print(tribonacci[i] + " ");
        }

        for (int i = 3; i < num; i++) {
            tribonacci[i] = tribonacci[i - 1] + tribonacci[i - 2] + tribonacci[i - 3];
            System.out.print(tribonacci[i] + " ");
        }
    }
}
