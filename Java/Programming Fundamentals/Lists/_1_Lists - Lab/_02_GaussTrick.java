import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _02_GaussTrick {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Integer> list = Arrays.stream(sc.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int size = list.size();

        for (int i = 0; i < size / 2; i++) {
            int sum = list.get(i) + list.get(list.size() - 1);
            list.set(i, sum);
            list.remove(list.size() - 1);
        }

        for (Integer number : list) {
            System.out.print(number + " ");
        }
    }
}
