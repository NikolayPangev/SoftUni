import java.util.Scanner;

public class _11_MathOperations {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double number1 = sc.nextDouble();
        char operator = sc.next().charAt(0);
        double number2 = sc.nextDouble();

        switch (operator) {
            case '+' -> System.out.printf("%.2f", number1 + number2);
            case '-' -> System.out.printf("%.2f", number1 - number2);
            case '*' -> System.out.printf("%.2f", number1 * number2);
            case '/' -> System.out.printf("%.2f", number1 / number2);
        }
    }
}
