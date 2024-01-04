import java.util.Scanner;

public class _03_Histogram {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int p1 = 0, p2 = 0, p3 = 0, p4= 0, p5 = 0;

        for (int i = 0; i < n; i++) {
            int number = Integer.parseInt(scanner.nextLine());
            if (number < 200){
                p1++;
            } else if (number < 400) {
                p2++;
            } else if (number < 600) {
                p3++;
            } else if (number < 800) {
                p4++;
            } else {
                p5++;
            }
        }
        System.out.printf("%.2f%%\n", returnPercents(p1, n));
        System.out.printf("%.2f%%\n", returnPercents(p2, n));
        System.out.printf("%.2f%%\n", returnPercents(p3, n));
        System.out.printf("%.2f%%\n", returnPercents(p4, n));
        System.out.printf("%.2f%%\n", returnPercents(p5, n));
    }

    private static double returnPercents(int percent, int number){
     return (double) percent / number * 100;
    }
}
