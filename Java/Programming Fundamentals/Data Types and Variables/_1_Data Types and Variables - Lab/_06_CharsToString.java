import java.util.Scanner;

public class _06_CharsToString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char ch1 = scanner.nextLine().charAt(0);
        char ch2 = scanner.nextLine().charAt(0);
        char ch3 = scanner.nextLine().charAt(0);

        String output = "";
        output = output + ch1 + ch2 + ch3;
        System.out.println(output);
    }
}
