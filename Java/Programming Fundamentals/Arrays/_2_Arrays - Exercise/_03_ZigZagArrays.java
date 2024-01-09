import java.util.Scanner;

public class _03_ZigZagArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = Integer.parseInt(scanner.nextLine());
        int count = 0;
        int[] leftArray = new int[number];
        int[] rightArray = new int[number];


        for (int i = 0; i < number; i++) {
            String[] array = scanner.nextLine().split(" ");
            int arrayFirstEl = Integer.parseInt(array[0]);
            int arraySecondEl = Integer.parseInt(array[1]);

            if (count % 2 == 0) {
                leftArray[count] = arrayFirstEl;
                rightArray[count] = arraySecondEl;
            } else {
                leftArray[count] = arraySecondEl;
                rightArray[count] = arrayFirstEl;
            }

            count++;
        }
        printArray(leftArray);
        printArray(rightArray);
    }

    private static void printArray(int[] array) {
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}