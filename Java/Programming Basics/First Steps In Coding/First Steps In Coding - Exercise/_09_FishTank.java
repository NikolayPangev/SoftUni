import java.util.Scanner;

public class _09_FishTank {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int length = Integer.parseInt(scanner.nextLine());
        int width = Integer.parseInt(scanner.nextLine());
        int height = Integer.parseInt(scanner.nextLine());
        double percent = Double.parseDouble(scanner.nextLine());

        double volume = length * width * height;
        double volumeInLiters = volume / 1000;
        percent /= 100.0;

        double neededLiters =  volumeInLiters * (1 - percent);
        System.out.println(neededLiters);
    }
}