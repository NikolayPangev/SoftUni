import java.util.Scanner;

public class _03_RecursiveFibonacci {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int number = sc.nextInt();

        System.out.println(getFibonacci(number));
    }

    public static int getFibonacci(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }
        return getFibonacci(n - 1) + getFibonacci(n - 2);
    }
}
