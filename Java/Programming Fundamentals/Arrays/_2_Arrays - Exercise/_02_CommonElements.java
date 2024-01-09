import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class _02_CommonElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] firstArr = scanner.nextLine().split(" ");
        String[] secondArr = scanner.nextLine().split(" ");

        for (String elementSecondArr : secondArr) {
            for (String elementFirstArr : firstArr) {
                if (elementSecondArr.equals(elementFirstArr)) {
                    System.out.print(elementFirstArr + " ");
                    break;
                }
            }
        }
    }
}