import java.util.Scanner;

public class _06_CinemaTickets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int studentTickets = 0;
        int kidTickets = 0;
        int standardTickets = 0;
        int totalTickets = 0;

        String movieName = scanner.nextLine();
        while (!movieName.equals("Finish")) {

            int availableSeats = Integer.parseInt(scanner.nextLine());

            int takenSeats = 0;

            String ticketType = scanner.nextLine();
            while (!ticketType.equals("End")) {
                takenSeats++;

                totalTickets++;
                switch (ticketType) {
                    case "student":
                        studentTickets++;
                        break;
                    case "kid":
                        kidTickets++;
                        break;
                    case "standard":
                        standardTickets++;
                        break;
                }
                if (takenSeats == availableSeats) {
                    break;
                }
                ticketType = scanner.nextLine();
            }
            System.out.printf("%s - %.2f%% full.%n", movieName, takenSeats * 1.0 / availableSeats * 100);
            movieName = scanner.nextLine();
        }
        System.out.println("Total tickets: " + totalTickets);
        System.out.printf("%.2f%% student tickets.\n", studentTickets * 1.0 / totalTickets * 100);
        System.out.printf("%.2f%% standard tickets.\n", standardTickets * 1.0 / totalTickets * 100);
        System.out.printf("%.2f%% kids tickets.\n", kidTickets * 1.0 / totalTickets * 100);
    }
}