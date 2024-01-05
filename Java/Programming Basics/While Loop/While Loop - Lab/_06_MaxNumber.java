import java.util.Scanner;

public class _06_MaxNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int max = Integer.MIN_VALUE;

        String command = scanner.nextLine();

        while (!command.equals("Stop")) {
            int number = Integer.parseInt(command);

            if (max < number) {
                max = number;
            }

            command = scanner.nextLine();
        }
        System.out.println(max);
    }
}