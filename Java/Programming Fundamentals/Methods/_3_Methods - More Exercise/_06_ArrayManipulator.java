import java.util.Arrays;
import java.util.Scanner;

public class _06_ArrayManipulator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] array = Arrays.stream(sc.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        String command = sc.nextLine();

        while (!command.equals("end")) {
            String[] tokens = command.split(" ");
            String action = tokens[0];

            switch (action) {
                case "exchange":
                    int index = Integer.parseInt(tokens[1]);
                    if (index < 0 || index >= array.length) {
                        System.out.println("Invalid index");
                    } else {
                        array = exchange(array, index);
                    }
                    break;
                case "max":
                    String evenOrOdd = tokens[1];
                    int maxIndex;
                    if (evenOrOdd.equals("even")) {
                        maxIndex = findMaxEvenIndex(array);
                    } else {
                        maxIndex = findMaxOddIndex(array);
                    }
                    if (maxIndex == -1) {
                        System.out.println("No matches");
                    } else {
                        System.out.println(maxIndex);
                    }
                    break;
                case "min":
                    evenOrOdd = tokens[1];
                    int minIndex;
                    if (evenOrOdd.equals("even")) {
                        minIndex = findMinEvenIndex(array);
                    } else {
                        minIndex = findMinOddIndex(array);
                    }
                    if (minIndex == -1) {
                        System.out.println("No matches");
                    } else {
                        System.out.println(minIndex);
                    }
                    break;
                case "first":
                    int count = Integer.parseInt(tokens[1]);
                    evenOrOdd = tokens[2];
                    if (count > array.length) {
                        System.out.println("Invalid count");
                    } else {
                        System.out.println(Arrays.toString(findFirst(array, count, evenOrOdd)));
                    }
                    break;
                case "last":
                    count = Integer.parseInt(tokens[1]);
                    evenOrOdd = tokens[2];
                    if (count > array.length) {
                        System.out.println("Invalid count");
                    } else {
                        System.out.println(Arrays.toString(findLast(array, count, evenOrOdd)));
                    }
                    break;
            }

            command = sc.nextLine();
        }
        System.out.println(Arrays.toString(array));
    }

    private static int[] exchange(int[] array, int index) {
        int[] result = new int[array.length];
        System.arraycopy(array, index + 1, result, 0, array.length - index - 1);
        System.arraycopy(array, 0, result, array.length - index - 1, index + 1);
        return result;
    }

    private static int findMaxEvenIndex(int[] array) {
        int maxIndex = -1;
        int maxValue = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0 && array[i] >= maxValue) {
                maxValue = array[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    private static int findMaxOddIndex(int[] array) {
        int maxIndex = -1;
        int maxValue = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 != 0 && array[i] >= maxValue) {
                maxValue = array[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    private static int findMinEvenIndex(int[] array) {
        int minIndex = -1;
        int minValue = Integer.MAX_VALUE;
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0 && array[i] <= minValue) {
                minValue = array[i];
                minIndex = i;
            }
        }
        return minIndex;
    }

    private static int findMinOddIndex(int[] array) {
        int minIndex = -1;
        int minValue = Integer.MAX_VALUE;
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 != 0 && array[i] <= minValue) {
                minValue = array[i];
                minIndex = i;
            }
        }
        return minIndex;
    }

    private static int[] findFirst(int[] array, int count, String evenOrOdd) {
        int[] result = new int[count];
        int found = 0;
        for (int num : array) {
            if ((evenOrOdd.equals("even") && num % 2 == 0) || (evenOrOdd.equals("odd") && num % 2 != 0)) {
                result[found++] = num;
                if (found == count) {
                    break;
                }
            }
        }
        return Arrays.copyOf(result, found);
    }

    private static int[] findLast(int[] array, int count, String evenOrOdd) {
        int[] result = new int[count];
        int found = 0;
        for (int i = array.length - 1; i >= 0; i--) {
            if ((evenOrOdd.equals("even") && array[i] % 2 == 0) || (evenOrOdd.equals("odd") && array[i] % 2 != 0)) {
                result[found++] = array[i];
                if (found == count) {
                    break;
                }
            }
        }
        int[] finalResult = new int[found];
        for (int i = 0; i < found; i++) {
            finalResult[i] = result[found - 1 - i];
        }
        return finalResult;
    }
}
