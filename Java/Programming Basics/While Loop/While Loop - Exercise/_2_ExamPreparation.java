import java.util.Scanner;

public class _2_ExamPreparation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numBadGrades = Integer.parseInt(scanner.nextLine());
        String taskName = scanner.nextLine();
        int grade = Integer.parseInt(scanner.nextLine());
        double averageScore;
        int score = 0;
        int numProblems = 0;
        int countBadGrades = 0;
        String lastName = null;

        while (!taskName.equals("Enough")) {
            score += grade;
            numProblems++;

            if (grade <= 4) {
                countBadGrades++;
            }

            if (countBadGrades == numBadGrades) {
                System.out.printf("You need a break, %d poor grades.", countBadGrades);
                return;
            }
            lastName = taskName;
            taskName = scanner.nextLine();
            if (!taskName.equals("Enough")) {
                grade = Integer.parseInt(scanner.nextLine());
            }
        }

        averageScore = (double) score / numProblems;
        System.out.printf("Average score: %.2f\n", averageScore);
        System.out.printf("Number of problems: %d\n", numProblems);
        System.out.printf("Last problem: %s\n", lastName);
    }
}