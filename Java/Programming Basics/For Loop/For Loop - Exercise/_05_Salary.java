import java.util.Scanner;

public class _05_Salary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int openTabs = Integer.parseInt(scanner.nextLine());
        int salary = Integer.parseInt(scanner.nextLine());

        for (int currentTab = 0; currentTab < openTabs; currentTab++) {
            String tabName = scanner.nextLine();

            if (tabName.equals("Facebook")) {
                salary -= 150;
            } else if (tabName.equals("Instagram")) {
                salary -= 100;
            } else if (tabName.equals("Reddit")) {
                salary -= 50;
            }

            if (salary <= 0) {
                System.out.println("You have lost your salary.");
                break;
            }
        }

        if (salary > 0) {
            System.out.println(salary);
        }
    }
}