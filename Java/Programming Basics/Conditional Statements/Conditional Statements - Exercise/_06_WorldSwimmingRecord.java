import java.util.Scanner;

public class _06_WorldSwimmingRecord {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double recordInSec = Double.parseDouble(scanner.nextLine());
        double distance = Double.parseDouble(scanner.nextLine());
        double timeInSec = Double.parseDouble(scanner.nextLine());

        double neededDistance = distance * timeInSec;
        double delay = Math.floor(distance / 15);
        double delayedTime = delay * 12.5;
        double totalTime = neededDistance + delayedTime;

        if (recordInSec <= totalTime) {
            System.out.printf("No, he failed! He was %.2f seconds slower.", (totalTime - recordInSec));
        } else {
            System.out.printf("Yes, he succeeded! The new world record is %.2f seconds.", (totalTime));
        }
    }
}
