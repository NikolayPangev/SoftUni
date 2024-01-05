import java.util.Scanner;

public class _08_TennisRanklist {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numTournament = Integer.parseInt(scanner.nextLine());
        int beginnerPoints = Integer.parseInt(scanner.nextLine());
        int pointsFromTournaments = 0;
        double wonTournaments = 0;

        for (int i = 0; i < numTournament; i++) {
            String stage = scanner.nextLine();
            if (stage.equals("F")) {
                beginnerPoints += 1200;
                pointsFromTournaments += 1200;
            } else if (stage.equals("SF")) {
                beginnerPoints += 720;
                pointsFromTournaments += 720;
            } else if (stage.equals("W")) {
                beginnerPoints += 2000;
                pointsFromTournaments += 2000;
                wonTournaments++;
            }
        }

        System.out.printf("Final points: %d\n", beginnerPoints);
        System.out.printf("Average points: %d\n", pointsFromTournaments / numTournament);
        System.out.printf("%.2f%%", wonTournaments / numTournament * 100);
    }
}