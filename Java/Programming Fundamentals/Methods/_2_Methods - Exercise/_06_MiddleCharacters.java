import java.util.Scanner;

public class _06_MiddleCharacters {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();

        if (str.length() % 2 == 0) {
            System.out.println(str.charAt(str.length()/2-1) + "" + str.charAt(str.length()/2));
        } else {
            System.out.println(str.charAt(str.length()/2));
        }
    }
}