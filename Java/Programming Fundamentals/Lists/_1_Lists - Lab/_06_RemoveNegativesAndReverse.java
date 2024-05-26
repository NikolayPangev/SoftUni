import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _06_RemoveNegativesAndReverse {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(sc.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

        numbers.removeIf(number -> number < 0);
        Collections.reverse(numbers);

        for (Integer number : numbers) {
            System.out.print(number + " ");
        }

        if (numbers.isEmpty()){
            System.out.println("empty");
        }
    }
}
