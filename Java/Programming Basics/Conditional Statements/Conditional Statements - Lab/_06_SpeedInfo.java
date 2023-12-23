import java.util.Scanner;

public class _06_SpeedInfo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double number = Double.parseDouble(scanner.nextLine());

        if (number <= 10) {
            System.out.println("slow");
        } else if (number <= 50) {
            System.out.println("average");
        } else if (number <= 150) {
            System.out.println("fast");
        } else if (number <= 1000) {
            System.out.println("ultra fast");
        } else {
            System.out.println("extremely fast");
        }
    }
}