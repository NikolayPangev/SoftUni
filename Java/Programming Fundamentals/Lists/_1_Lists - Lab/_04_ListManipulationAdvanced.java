import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _04_ListManipulationAdvanced {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Integer> list = Arrays.stream(sc.nextLine().split(" "))
                .map(Integer::parseInt)
                .toList();

        String command = sc.nextLine();

        while (!command.equals("end")) {
            String[] tokens = command.split(" ");
            String action = tokens[0];

            switch (action) {
                case "Contains":
                    int number = Integer.parseInt(tokens[1]);
                    System.out.println(list.contains(number) ? "Yes" : "No such number");
                    break;

                case "Print":
                    String evenOrOdd = tokens[1];
                    list.stream()
                            .filter(n -> (evenOrOdd.equals("even") && n % 2 == 0) || (evenOrOdd.equals("odd") && n % 2 != 0))
                            .forEach(n -> System.out.print(n + " "));
                    System.out.println();
                    break;

                case "Get":
                    int sum = list.stream().mapToInt(Integer::intValue).sum();
                    System.out.println(sum);
                    break;

                case "Filter":
                    String condition = tokens[1];
                    number = Integer.parseInt(tokens[2]);
                    list.stream()
                            .filter(n -> switch (condition) {
                                case ">" -> n > number;
                                case "<" -> n < number;
                                case ">=" -> n >= number;
                                case "<=" -> n <= number;
                                default -> false;
                            })
                            .forEach(n -> System.out.print(n + " "));
                    System.out.println();
                    break;
            }
            command = sc.nextLine();
        }
    }
}
