import java.util.Arrays;
import java.util.Scanner;

public class _10_TheLift {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int people = Integer.parseInt(sc.nextLine());
        int[] wagons = Arrays.stream(sc.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        for (int i = 0; i < wagons.length && people > 0; i++) {
            int spaceAvailable = 4 - wagons[i];
            int peopleToAdd = Math.min(spaceAvailable, people);
            wagons[i] += peopleToAdd;
            people -= peopleToAdd;
        }

        if (people > 0) {
            System.out.printf("There isn't enough space! %d people in a queue!\n", people);
        } else if (Arrays.stream(wagons).anyMatch(w -> w < 4)) {
            System.out.println("The lift has empty spots!");
        }

        for (int wagon : wagons) {
            System.out.print(wagon + " ");
        }
    }
}
