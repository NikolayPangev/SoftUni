import java.util.Arrays;
import java.util.Scanner;

public class _09_ArrayModifier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] array = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        String command = scanner.nextLine();

        while (!command.equals("end")) {
            String[] commandArgs = command.split(" ");
            String commandType = commandArgs[0];


            switch (commandType) {
                case "swap":
                    int index1 = Integer.parseInt(commandArgs[1]);
                    int index2 = Integer.parseInt(commandArgs[2]);
                    int temp = array[index1];
                    array[index1] = array[index2];
                    array[index2] = temp;
                    break;
                case "multiply":
                    index1 = Integer.parseInt(commandArgs[1]);
                    index2 = Integer.parseInt(commandArgs[2]);
                    array[index1] *= array[index2];
                    break;
                case "decrease":
                    for (int i = 0; i < array.length; i++) {
                        array[i] -= 1;
                    }
                    break;
            }

            command = scanner.nextLine();
        }

        System.out.println(Arrays.toString(array)
                .replace("[", "")
                .replace("]", "")
                .replace(", ", ", "));

    }
}