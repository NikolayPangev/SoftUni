import java.util.Scanner;

public class _06_OperationsBetweenNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num1 = Integer.parseInt(scanner.nextLine());
        int num2 = Integer.parseInt(scanner.nextLine());
        String operator = scanner.nextLine();
        double result = 0.0;
        String isDivisible;

        switch (operator) {
            case "+":
                result = num1 + num2;
                isDivisible = checkIfEvenOrOdd(result);
                System.out.printf("%d + %d = %.0f - %s", num1, num2, result, isDivisible);
                break;
            case "-":
                result = num1 - num2;
                isDivisible = checkIfEvenOrOdd(result);
                System.out.printf("%d - %d = %.0f - %s", num1, num2, result, isDivisible);
                break;
            case "*":
                result = num1 * num2;
                isDivisible = checkIfEvenOrOdd(result);
                System.out.printf("%d * %d = %.0f - %s", num1, num2, result, isDivisible);
                break;
            case "/":
                if (num2 == 0) {
                    System.out.printf("Cannot divide %d by zero", num1);
                    break;
                }
                result = (double) num1 / num2;
                System.out.printf("%d / %d = %.2f", num1, num2, result);
                break;
            case "%":
                if (num2 == 0) {
                    System.out.printf("Cannot divide %d by zero", num1);
                    break;
                }
                result = num1 % num2;
                System.out.printf("%d %% %d = %.0f", num1, num2, result);
                break;
        }
    }

    private static String checkIfEvenOrOdd(double number) {
        if (number % 2 == 0) {
            return "even";
        } else {
            return "odd";
        }
    }
}