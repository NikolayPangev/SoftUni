import java.util.Scanner;

public class _07_MinNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int min = Integer.MAX_VALUE;

        String command = scanner.nextLine();

        while (!command.equals("Stop")) {
            int number = Integer.parseInt(command);

            if (number < min) {
                min = number;
            }

            command = scanner.nextLine();
        }
        System.out.println(min);
    }
}