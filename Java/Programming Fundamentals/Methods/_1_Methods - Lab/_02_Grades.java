import java.util.Scanner;

public class _02_Grades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double num = Double.parseDouble(scanner.nextLine());

        if (num >= 2.00 && num < 3.00) {
            System.out.println("Fail");
        } else if (num < 3.50) {
            System.out.println("Poor");
        } else if (num < 4.50) {
            System.out.println("Good");
        } else if (num < 5.50) {
            System.out.println("Very good");
        } else if (num < 6.00) {
            System.out.println("Excellent");
        }
    }
}