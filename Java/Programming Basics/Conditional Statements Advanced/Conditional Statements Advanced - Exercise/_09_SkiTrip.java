import java.util.Scanner;

public class _09_SkiTrip {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int daysStay = Integer.parseInt(scanner.nextLine());
        String typeRoom = scanner.nextLine();
        String review = scanner.nextLine();

        int overnight = daysStay - 1;
        double totalPrice = 0;

        switch (typeRoom) {
            case "room for one person":
                totalPrice = overnight * 18.00;
                break;
            case "apartment":
                totalPrice = overnight * 25.00;
                break;
            case "president apartment":
                totalPrice = overnight * 35.00;
                break;
        }

        if (typeRoom.equals("apartment")) {

            if (overnight < 10) {
                totalPrice *= 0.70;
            } else if (overnight > 10 && overnight < 15) {
                totalPrice *= 0.65;
            } else {
                totalPrice *= 0.50;
            }

        } else if (typeRoom.equals("president apartment")) {

            if (overnight < 10) {
                totalPrice *= 0.90;
            } else if (overnight > 10 && overnight < 15) {
                totalPrice *= 0.85;
            } else {
                totalPrice *= 0.80;
            }

        }

        if (review.equals("positive")) {
            totalPrice *= 1.25;
        } else if (review.equals("negative")) {
            totalPrice *= 0.90;
        }

        System.out.printf("%.2f", totalPrice);
    }
}