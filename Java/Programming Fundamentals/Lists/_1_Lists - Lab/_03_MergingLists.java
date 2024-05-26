import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _03_MergingLists {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Integer> list1 = Arrays.stream(sc.nextLine().split(" "))
                .map(Integer::parseInt)
                .toList();

        List<Integer> list2 = Arrays.stream(sc.nextLine().split(" "))
                .map(Integer::parseInt)
                .toList();

        List<Integer> mergedList = new ArrayList<>();

        int maxSize = Math.max(list1.size(), list2.size());

        for (int i = 0; i < maxSize; i++) {
            if (i < list1.size()) {
                mergedList.add(list1.get(i));
            }
            if (i < list2.size()) {
                mergedList.add(list2.get(i));
            }
        }

        for (Integer num : mergedList) {
            System.out.print(num + " ");
        }
    }
}
