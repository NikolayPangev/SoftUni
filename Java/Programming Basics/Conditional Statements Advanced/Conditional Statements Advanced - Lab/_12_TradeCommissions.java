import java.util.Scanner;

public class _12_TradeCommissions {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String town = scanner.nextLine();
        double volumeSells = Double.parseDouble(scanner.nextLine());

        switch (town) {
            case "Sofia":
                if (volumeSells < 0) {
                    System.out.println("error");
                    break;
                } else if (volumeSells >= 0 && volumeSells <= 500) {
                    volumeSells *= 0.05;
                } else if (volumeSells <= 1000) {
                    volumeSells *= 0.07;
                } else if (volumeSells <= 10000) {
                    volumeSells *= 0.08;
                } else if (volumeSells > 10000) {
                    volumeSells *= 0.12;
                }
                System.out.printf("%.2f", volumeSells);
                break;
            case "Varna":
                if (volumeSells < 0) {
                    System.out.println("error");
                    break;
                } else if (volumeSells >= 0 && volumeSells <= 500) {
                    volumeSells *= 0.045;
                } else if (volumeSells <= 1000) {
                    volumeSells *= 0.075;
                } else if (volumeSells <= 10000) {
                    volumeSells *= 0.1;
                } else if (volumeSells > 10000) {
                    volumeSells *= 0.13;
                }
                System.out.printf("%.2f", volumeSells);
                break;
            case "Plovdiv":
                if (volumeSells < 0) {
                    System.out.println("error");
                    break;
                } else if (volumeSells >= 0 && volumeSells <= 500) {
                    volumeSells *= 0.055;
                } else if (volumeSells <= 1000) {
                    volumeSells *= 0.08;
                } else if (volumeSells <= 10000) {
                    volumeSells *= 0.12;
                } else if (volumeSells > 10000) {
                    volumeSells *= 0.145;
                }
                System.out.printf("%.2f", volumeSells);
                break;
            default:
                System.out.println("error");
                break;
        }
    }
}