import java.util.Arrays;
import java.util.Scanner;

public class _06_EqualSums {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int resultIndex = findEqualSumIndex(numbers);

        if (resultIndex != -1) {
            System.out.println(resultIndex);
        } else {
            System.out.println("no");
        }
    }

    private static int findEqualSumIndex(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (isIndexWithEqualSum(arr, i)) {
                return i;
            }
        }
        return -1;
    }

    static boolean isIndexWithEqualSum(int[] array, int index) {
        int leftSum = 0;
        int rightSum = 0;

        for (int i = 0; i < index; i++) {
            leftSum += array[i];
        }

        for (int i = index + 1; i < array.length; i++) {
            rightSum += array[i];
        }

        return leftSum == rightSum;
    }
}