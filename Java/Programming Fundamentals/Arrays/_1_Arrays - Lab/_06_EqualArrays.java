import java.util.Arrays;
import java.util.Scanner;

public class _06_EqualArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] firstArr = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] secondArr = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int maxLength = firstArr.length;
        int sum = 0;
        boolean isEven = true;

        for (int i = 0; i < maxLength; i++) {
            sum += firstArr[i];
            if (firstArr[i] != secondArr[i]) {
                System.out.printf("Arrays are not identical. Found difference at %d index.", i);
                isEven = false;
                break;
            }
        }
        if (isEven) {
            System.out.printf("Arrays are identical. Sum: %d", sum);
        }
    }
}