import java.util.Scanner;

public class _09_GreaterOfTwoValues {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String command = sc.nextLine();

        switch (command) {
            case "int":
                int number1 = Integer.parseInt(sc.nextLine());
                int number2 = Integer.parseInt(sc.nextLine());
                int result = getMax(number1, number2);
                System.out.println(result);
                break;
            case "char":
                char ch1 = sc.nextLine().charAt(0);
                char ch2 = sc.nextLine().charAt(0);
                char resultChar = getMax(ch1, ch2);
                System.out.println(resultChar);
                break;
            case "string":
                String string1 = sc.nextLine();
                String string2 = sc.nextLine();
                String resultString = getMax(string1, string2);
                System.out.println(resultString);
                break;
        }
    }

    public static int getMax(int a, int b) {
        return Math.max(a, b);
    }

    public static char getMax(char first, char last) {
        return (first > last) ? first : last;
    }

    public static String getMax(String first, String last) {
        return (first.compareTo(last) >= 0) ? first : last;
    }
}
