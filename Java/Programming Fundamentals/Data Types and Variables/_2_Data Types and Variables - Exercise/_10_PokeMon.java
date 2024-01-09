import java.util.Scanner;

public class _10_PokeMon {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = Integer.parseInt(scanner.nextLine());
        int M = Integer.parseInt(scanner.nextLine());
        int Y = Integer.parseInt(scanner.nextLine());
        int count = 0;
        int originalPower = N;

        while (N >= M) {
            N -= M;
            count++;

            if (N == originalPower / 2 && Y != 0) {
                N /= Y;
            }
        }

        System.out.println(N);
        System.out.println(count);
    }
}
