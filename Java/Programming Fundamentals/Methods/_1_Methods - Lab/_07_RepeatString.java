import java.util.Scanner;

public class _07_RepeatString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
        int count = Integer.parseInt(sc.nextLine());
        StringBuilder output = new StringBuilder();

        for (int i = 0; i < count; i++) {
            output.append(text);
        }
        System.out.println(output);
    }
}