import java.util.Scanner;

public class _06_Oscars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String nameActor = scanner.nextLine();
        double academyPoints = Double.parseDouble(scanner.nextLine());
        int numEvaluators = Integer.parseInt(scanner.nextLine());

        for (int currentEvaluator = 0; currentEvaluator < numEvaluators; currentEvaluator++) {
            String nameEvaluator = scanner.nextLine();
            double pointsEvaluator = Double.parseDouble(scanner.nextLine());

            academyPoints += nameEvaluator.length() * pointsEvaluator / 2;

            if (academyPoints >= 1250.5) {
                System.out.printf("Congratulations, %s got a nominee for leading role with %.1f!", nameActor, academyPoints);
                break;
            }
        }
        if (academyPoints < 1250.5) {
            System.out.printf("Sorry, %s you need %.1f more!", nameActor, 1250.5 - academyPoints);

        }
    }
}