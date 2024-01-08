import java.util.Scanner;

public class _08_LowerOrUpper {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char symbol = scanner.nextLine().charAt(0);
        if (Character.isLowerCase(symbol)) {
            System.out.println("lower-case");
        } else if (Character.isUpperCase(symbol)) {
            System.out.println("upper-case");
        }
    }
}