import java.util.Scanner;

public class _08_OnTimeForTheExam {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int hoursExam = Integer.parseInt(scanner.nextLine());
        int minutesExam = Integer.parseInt(scanner.nextLine());
        int hoursArrival = Integer.parseInt(scanner.nextLine());
        int minutesArrival = Integer.parseInt(scanner.nextLine());

        int allMinutesExam = hoursExam * 60 + minutesExam;
        int allMinutesArrival = hoursArrival * 60 + minutesArrival;
        int differenceInTime = allMinutesExam - allMinutesArrival;

        if (differenceInTime < 0) {
            System.out.println("Late");
            printTime(Math.abs(differenceInTime));
            System.out.println(" after the start");
        } else if (differenceInTime == 0) {
            System.out.println("On time");
        } else if (differenceInTime <= 30) {
            System.out.println("On time");
            printTime(differenceInTime);
            System.out.println(" before the start");
        } else {
            System.out.println("Early");
            printTime(differenceInTime);
            System.out.println(" before the start");
        }
    }

    private static void printTime(int differenceInTime) {
        int hours = differenceInTime / 60;
        int minutes = differenceInTime % 60;

        if (hours == 0) {
            System.out.printf("%d minutes", minutes);
        } else {
            System.out.printf("%d:%02d hours", hours, minutes);
        }
    }
}
