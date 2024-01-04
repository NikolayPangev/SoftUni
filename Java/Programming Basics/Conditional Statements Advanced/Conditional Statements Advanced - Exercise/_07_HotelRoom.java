import java.util.Scanner;

public class _07_HotelRoom {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String month = scanner.nextLine();
        int nights = Integer.parseInt(scanner.nextLine());
        double studio = 0;
        double apartment = 0;

        switch (month) {
            case "May":
            case "October":
                studio = 50;
                apartment = 65;
                if (nights > 7 && nights <= 14) {
                    studio *= 0.95;
                } else if (nights > 14) {
                    studio *= 0.70;
                    apartment *= 0.90;
                }
                break;
            case "June":
            case "September":
                studio = 75.20;
                apartment = 68.70;
                if (nights > 14) {
                    studio *= 0.80;
                    apartment *= 0.90;
                }
                break;
            case "July":
            case "August":
                studio = 76;
                apartment = 77;
                if (nights > 14) {
                    apartment *= 0.90;
                }
                break;
        }

        double studioTotal = nights * studio;
        double apartmentTotal = nights * apartment;

        System.out.printf("Apartment: %.2f lv.\n", apartmentTotal);
        System.out.printf("Studio: %.2f lv.", studioTotal);
    }
}
