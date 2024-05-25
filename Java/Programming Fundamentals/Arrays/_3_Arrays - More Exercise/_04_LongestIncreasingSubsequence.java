import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class _04_LongestIncreasingSubsequence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] numbers = Arrays.stream(sc.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        List<Integer> lis = findLongestIncreasingSubsequence(numbers);

        for (Integer num : lis) {
            System.out.print(num + " ");
        }
    }

    private static List<Integer> findLongestIncreasingSubsequence(int[] numbers) {
        if (numbers.length == 0) {
            return new ArrayList<>();
        }

        int[] len = new int[numbers.length];
        int[] prev = new int[numbers.length];

        Arrays.fill(prev, -1);

        int maxLength = 0;
        int endIndex = 0;

        for (int i = 0; i < numbers.length; i++) {
            len[i] = 1;
            for (int j = 0; j < i; j++) {
                if (numbers[i] > numbers[j] && len[j] + 1 > len[i]) {
                    len[i] = len[j] + 1;
                    prev[i] = j;
                }
            }

            if (len[i] > maxLength) {
                maxLength = len[i];
                endIndex = i;
            }
        }

        List<Integer> lis = new ArrayList<>();
        for (int i = endIndex; i != -1; i = prev[i]) {
            lis.addFirst(numbers[i]);
        }

        return lis;
    }
}
