import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _01_ListManipulationBasics {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Integer> list = Arrays.stream(sc.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

        String command = sc.nextLine();

        while (!command.equals("end")) {
            String[] tokens = command.split(" ");
            String action = tokens[0];

            switch (action) {
                case "Add":
                    int numberToAdd = Integer.parseInt(tokens[1]);
                    list.add(numberToAdd);
                    break;
                case "Remove":
                    int numberToRemove = Integer.parseInt(tokens[1]);
                    list.remove(Integer.valueOf(numberToRemove));
                    break;
                case "RemoveAt":
                    int indexToRemove = Integer.parseInt(tokens[1]);
                    list.remove(indexToRemove);
                    break;
                case "Insert":
                    int numberToInsert = Integer.parseInt(tokens[1]);
                    int indexToInsert = Integer.parseInt(tokens[2]);
                    list.add(indexToInsert, numberToInsert);
                    break;
            }
            command = sc.nextLine();
        }
        for (Integer number : list) {
            System.out.print(number + " ");
        }
    }
}
