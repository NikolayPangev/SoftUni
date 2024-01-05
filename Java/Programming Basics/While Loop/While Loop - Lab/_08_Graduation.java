import java.util.Scanner;

public class _08_Graduation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        int countGrade = 1;
        double totalGrades = 0;


        while (countGrade <= 12) {
            double currentGrade = Double.parseDouble(scanner.nextLine());
            if (currentGrade >= 4.00) {
                totalGrades += currentGrade;
            } else {
                System.out.printf("%s has been excluded at %d grade", name, countGrade);
                return;
            }
            countGrade++;
        }
        double averageGrade = totalGrades / 12;
        System.out.printf("%s graduated. Average grade: %.2f", name, averageGrade);
    }
}