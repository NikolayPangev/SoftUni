import java.util.Scanner;

public class _04_EvenPowersOf2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i <= number; i++) {
            if (i % 2 == 0) {
                int result = (int) Math.pow(2, i);
                System.out.println(result);
            }
        }
    }
}