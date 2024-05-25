import java.util.Arrays;
import java.util.Scanner;

public class _06_LadyBugs {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int fieldSize = Integer.parseInt(sc.nextLine());

        int[] field = new int[fieldSize];
        Arrays.fill(field, 0);

        int[] initialIndexes = Arrays.stream(sc.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        for (int index : initialIndexes) {
            if (index >= 0 && index < fieldSize) {
                field[index] = 1;
            }
        }

        String command = sc.nextLine();
        while (!command.equals("end")) {
            String[] parts = command.split(" ");
            int ladybugIndex = Integer.parseInt(parts[0]);
            String direction = parts[1];
            int flyLength = Integer.parseInt(parts[2]);

            if (ladybugIndex >= 0 && ladybugIndex < fieldSize && field[ladybugIndex] == 1) {
                field[ladybugIndex] = 0;

                int newPosition = ladybugIndex;
                boolean hasLanded = false;

                while (!hasLanded) {
                    if (direction.equals("right")) {
                        newPosition += flyLength;
                    } else if (direction.equals("left")) {
                        newPosition -= flyLength;
                    }

                    if (newPosition < 0 || newPosition >= fieldSize) {
                        break;
                    }

                    if (field[newPosition] == 0) {
                        field[newPosition] = 1;
                        hasLanded = true;
                    }
                }
            }

            command = sc.nextLine();
        }

        for (int cell : field) {
            System.out.print(cell + " ");
        }
    }
}
