import java.util.Scanner;

public class _06_Repainting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int nylon = Integer.parseInt(scanner.nextLine());
        int paint = Integer.parseInt(scanner.nextLine());
        int thinner = Integer.parseInt(scanner.nextLine());
        int hours = Integer.parseInt(scanner.nextLine());

        double sumNylon = (nylon + 2) * 1.50;
        double sumPaint = (paint + paint * 0.1) * 14.50;
        double sumThinner = thinner * 5.00;
        double sumBag = 0.40;

        double totalSumMaterials = sumNylon + sumPaint + sumThinner + sumBag;
        double sumWorkers = (totalSumMaterials * 0.3) * hours;

        double totalSum = totalSumMaterials + sumWorkers;
        System.out.printf("%.2f%n", totalSum);
    }
}
