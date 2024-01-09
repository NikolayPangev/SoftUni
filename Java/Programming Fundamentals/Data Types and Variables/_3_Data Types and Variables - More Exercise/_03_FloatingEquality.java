import java.util.Scanner;

public class _03_FloatingEquality {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double eps = 0.000001;

        double firstNumber = Double.parseDouble(scanner.nextLine());
        double secondNumber = Double.parseDouble(scanner.nextLine());

        if (Math.abs(firstNumber - secondNumber) < eps){
            System.out.println("True");
        } else {
            System.out.println("False");
        }
    }
}