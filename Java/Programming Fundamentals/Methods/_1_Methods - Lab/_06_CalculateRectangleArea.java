import java.util.Scanner;

public class _06_CalculateRectangleArea {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double width = sc.nextInt();
        double height = sc.nextInt();

        double area = calculateRectangleArea(width, height);
        System.out.println(area);
    }

    public static double calculateRectangleArea(double width, double height) {
        return width * height;
    }
}
