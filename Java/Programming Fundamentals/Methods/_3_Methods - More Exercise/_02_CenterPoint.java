import java.util.Scanner;

public class _02_CenterPoint {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int x1 = sc.nextInt();
        int y1 = sc.nextInt();
        int x2 = sc.nextInt();
        int y2 = sc.nextInt();

        closerPoint(x1, y1, x2, y2);
    }

    private static void closerPoint(int x1, int y1, int x2, int y2) {
        int point1 = x1 + y1;
        int point2 = x2 + y2;

        if (point1 > point2) {
            System.out.printf("(%d, %d)", x2, y2);
        } else {
            System.out.printf("(%d, %d)", x1, y1);
        }
    }
}
