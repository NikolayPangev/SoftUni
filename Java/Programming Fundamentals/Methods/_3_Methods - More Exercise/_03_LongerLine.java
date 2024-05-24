import java.util.Scanner;

public class _03_LongerLine {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int x1 = sc.nextInt();
        int y1 = sc.nextInt();
        int x2 = sc.nextInt();
        int y2 = sc.nextInt();

        int x3 = sc.nextInt();
        int y3 = sc.nextInt();
        int x4 = sc.nextInt();
        int y4 = sc.nextInt();

        double length1 = calculateDistance(x1, y1, x2, y2);
        double length2 = calculateDistance(x3, y3, x4, y4);

        if (length1 >= length2) {
            printLineCloserToCenter(x1, y1, x2, y2);
        } else {
            printLineCloserToCenter(x3, y3, x4, y4);
        }
    }

    private static double calculateDistance(int x1, int y1, int x2, int y2) {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }

    private static void printLineCloserToCenter(int x1, int y1, int x2, int y2) {
        double distance1 = calculateDistance(x1, y1, 0, 0);
        double distance2 = calculateDistance(x2, y2, 0, 0);

        if (distance1 <= distance2) {
            System.out.printf("(%d, %d)(%d, %d)%n", x1, y1, x2, y2);
        } else {
            System.out.printf("(%d, %d)(%d, %d)%n", x2, y2, x1, y1);
        }
    }
}
