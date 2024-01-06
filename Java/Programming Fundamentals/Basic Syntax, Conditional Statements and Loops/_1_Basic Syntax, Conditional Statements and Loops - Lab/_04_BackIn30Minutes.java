import java.util.Scanner;

public class _04_BackIn30Minutes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int hours = Integer.parseInt(scanner.nextLine());
        int minutes = Integer.parseInt(scanner.nextLine());

        int allMinutes = hours * 60 + minutes;
        int minutesPlus30 = allMinutes + 30;

        hours = minutesPlus30 / 60;
        minutes = minutesPlus30 % 60;

        if (hours > 23) {
            hours -= 24;
        }

        if (minutes < 10) {
            System.out.printf("%d:0%d", hours, minutes);
        } else {
            System.out.printf("%d:%d", hours, minutes);
        }
    }
}