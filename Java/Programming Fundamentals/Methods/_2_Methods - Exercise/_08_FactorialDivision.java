import java.util.Scanner;

public class _08_FactorialDivision {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num1 = sc.nextInt();
        int num2 = sc.nextInt();

        double fact1 = factorial(num1);
        double fact2 = factorial(num2);

        double result = fact1 / fact2;
        System.out.printf("%.2f", result);

    }

    public static long factorial(int n) {
        long fact = 1;
        for (int i = 1; i <= n; i++) {
            fact *= i;
        }
        return fact;
    }
}
