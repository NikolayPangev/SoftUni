import java.util.Scanner;

public class _03_CharactersInRange {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char char1 = sc.next().charAt(0);
        char char2 = sc.next().charAt(0);

        printCharacters(char1, char2);
    }

    private static void printCharacters(char char1, char char2) {
        if (char1 > char2) {
            char temp = char1;
            char1 = char2;
            char2 = temp;
        }

        for (int i = char1 + 1; i < char2; i++) {
            System.out.print((char) i + " ");
        }
    }
}
