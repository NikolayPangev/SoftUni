import java.util.Scanner;

public class _04_Walking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();
        int totalSteps = 0;

        while (!command.equals("Going home")) {
            int steps = Integer.parseInt(command);
            totalSteps += steps;

            if (totalSteps >= 10000) {
                System.out.println("Goal reached! Good job!");
                System.out.printf("%d steps over the goal!", totalSteps - 10000);
                return;
            }

            command = scanner.nextLine();
        }
        int stepsBackHome = Integer.parseInt(scanner.nextLine());
        int allSteps = totalSteps + stepsBackHome;
        if (allSteps >= 10000) {
            System.out.println("Goal reached! Good job!");
            System.out.printf("%d steps over the goal!", allSteps - 10000);
        } else {
            System.out.printf("%d more steps to reach goal.", 10000 - allSteps);
        }
    }
}