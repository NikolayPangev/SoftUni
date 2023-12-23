import java.util.Scanner;

public class _07_AreaOfFigures {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String figure = scanner.nextLine();

        if (figure.equals("square")) {
            double side = Double.parseDouble(scanner.nextLine());
            double result = side * side;
            System.out.printf("%.3f", result);
        } else if (figure.equals("rectangle")) {
            double sideA = Double.parseDouble(scanner.nextLine());
            double sideB = Double.parseDouble(scanner.nextLine());
            double result = sideA * sideB;
            System.out.printf("%.3f", result);
        } else if (figure.equals("circle")) {
            double side = Double.parseDouble(scanner.nextLine());
            double result = side * side * Math.PI;
            System.out.printf("%.3f", result);
        } else if (figure.equals("triangle")) {
            double side = Double.parseDouble(scanner.nextLine());
            double height = Double.parseDouble(scanner.nextLine());
            double result = (side * height) / 2;
            System.out.printf("%.3f", result);
        }
    }
}