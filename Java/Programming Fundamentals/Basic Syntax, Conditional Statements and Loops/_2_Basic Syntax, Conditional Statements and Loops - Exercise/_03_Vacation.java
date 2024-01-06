import java.util.Scanner;

public class _03_Vacation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numPeople = Integer.parseInt(scanner.nextLine());
        String people = scanner.nextLine();
        String day = scanner.nextLine();
        double price;
        double totalSum = 0.00;

        switch (people) {
            case "Students":
                if (day.equals("Friday")) {
                    price = 8.45;
                    totalSum = numPeople * price;
                    if (numPeople >= 30) {
                        totalSum *= 0.85;
                    }
                } else if (day.equals("Saturday")) {
                    price = 9.80;
                    totalSum = numPeople * price;
                    if (numPeople >= 30) {
                        totalSum *= 0.85;
                    }
                } else if (day.equals("Sunday")) {
                    price = 10.46;
                    totalSum = numPeople * price;
                    if (numPeople >= 30) {
                        totalSum *= 0.85;
                    }
                }
                break;
            case "Business":
                if (day.equals("Friday")) {
                    price = 10.90;
                    totalSum = numPeople * price;
                    if (numPeople >= 100) {
                        totalSum = totalSum - 10 * price;
                    }
                } else if (day.equals("Saturday")) {
                    price = 15.60;
                    totalSum = numPeople * price;
                    if (numPeople >= 100) {
                        totalSum = totalSum - 10 * price;
                    }
                } else if (day.equals("Sunday")) {
                    price = 16;
                    totalSum = numPeople * price;
                    if (numPeople >= 100) {
                        totalSum = totalSum - 10 * price;
                    }
                }
                break;
            case "Regular":
                if (day.equals("Friday")) {
                    price = 15;
                    totalSum = numPeople * price;
                    if (numPeople >= 10 && numPeople <= 20) {
                        totalSum *= 0.95;
                    }
                } else if (day.equals("Saturday")) {
                    price = 20;
                    totalSum = numPeople * price;
                    if (numPeople >= 10 && numPeople <= 20) {
                        totalSum *= 0.95;
                    }
                } else if (day.equals("Sunday")) {
                    price = 22.50;
                    totalSum = numPeople * price;
                    if (numPeople >= 10 && numPeople <= 20) {
                        totalSum *= 0.95;
                    }
                }
                break;
        }
        System.out.printf("Total price: %.2f", totalSum);
    }
}