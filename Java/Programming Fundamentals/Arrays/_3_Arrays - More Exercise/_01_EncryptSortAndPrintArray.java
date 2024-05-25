import java.util.Arrays;
import java.util.Scanner;

public class _01_EncryptSortAndPrintArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = Integer.parseInt(sc.nextLine());
        int[] array = new int[number];

        for (int i = 0; i < number; i++) {
            String name = sc.nextLine();
            int sumVowel = 0;
            int sumConsonant = 0;

            for (int j = 0; j < name.length(); j++) {
                char ch = name.charAt(j);
                if (isVowel(ch)) {
                    sumVowel += ch * name.length();
                } else {
                    sumConsonant += ch / name.length();
                }
            }
            array[i] = sumVowel + sumConsonant;
        }

        Arrays.sort(array);

        printArray(array);
    }

    private static boolean isVowel(char ch) {
        return "AEIOUaeiou".indexOf(ch) != -1;
    }

    private static void printArray(int[] array) {
        for (int arr : array) {
            System.out.println(arr);
        }
    }
}
