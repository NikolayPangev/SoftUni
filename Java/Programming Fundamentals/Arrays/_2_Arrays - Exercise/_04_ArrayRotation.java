import java.util.Arrays;
import java.util.Scanner;

public class _04_ArrayRotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int numRotations = Integer.parseInt(scanner.nextLine());

        for (int rotation = 0; rotation < numRotations; rotation++) {
            int firstElement = numbers[0];

            for (int i = 0; i < numbers.length - 1; i++) {
                numbers[i] = numbers[i + 1];
            }

            numbers[numbers.length - 1] = firstElement;
        }

        for (int number : numbers) {
            System.out.print(number + " ");
        }
    }
}