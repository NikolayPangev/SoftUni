import java.util.Scanner;

public class _09_SpiceMustFlow {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int startingYield = Integer.parseInt(scanner.nextLine());
        int countDays = 0;
        int yieldInPossesion = 0;
        int extractedYield;

        while (startingYield >= 100) {
            countDays++;
            extractedYield = startingYield - 26;
            startingYield -= 10;
            yieldInPossesion += extractedYield;
        }
        if (yieldInPossesion > 26) {
            yieldInPossesion -= 26;
        }
        System.out.println(countDays);
        System.out.println(yieldInPossesion);
    }
}