import java.util.Scanner;

public class _08_LunchBreak {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String serial = scanner.nextLine();
        int episode = Integer.parseInt(scanner.nextLine());
        int lunchBreak = Integer.parseInt(scanner.nextLine());

        double timeForLunch = lunchBreak / 8.0;
        double timeForRest = lunchBreak / 4.0;

        double timeLeft = lunchBreak - timeForLunch - timeForRest;
        double diff = Math.ceil(Math.abs(timeLeft - episode));


        if (episode <= timeLeft) {
            System.out.printf("You have enough time to watch %s and left with %.0f minutes free time.", serial, diff);
        } else {
            System.out.printf("You don't have enough time to watch %s, you need %.0f more minutes.", serial, diff);
        }
    }
}
