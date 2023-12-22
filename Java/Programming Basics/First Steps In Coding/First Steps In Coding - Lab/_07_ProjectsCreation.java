import java.util.Scanner;

public class _07_ProjectsCreation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String architect = scanner.nextLine();
        int numOfProjects = Integer.parseInt(scanner.nextLine());
        int time = numOfProjects * 3;
        System.out.printf("The architect %s will need %d hours to complete %d project/s.", architect, time, numOfProjects);
    }
}