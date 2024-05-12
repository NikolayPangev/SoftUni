import java.util.Arrays;
import java.util.Scanner;

public class _07_CondenseArrayToNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] nums = Arrays.stream(sc.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        int result = condenseArray(nums);
        System.out.println(result);
    }

    public static int condenseArray(int[] nums) {
        while (nums.length > 1) {
            int[] condensed = new int[nums.length - 1];
            for (int i = 0; i < nums.length - 1; i++) {
                condensed[i] = nums[i] + nums[i + 1];
            }
            nums = condensed;
        }
        return nums[0];
    }
}
